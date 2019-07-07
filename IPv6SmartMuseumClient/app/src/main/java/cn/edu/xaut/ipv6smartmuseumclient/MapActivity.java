package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

/**
 * 地图Activity，用于提供导航
 * 用RecyclerView来形成网格地图，一张图片作为路径的图层
 * 未来优化方向：不断刷新的RecyclerView会影响滚动，现在想查看地图全图是需要暂停刷新的，应该有一种更智能的方法
 * 刷新的频率也需要继续调整，争取更加流畅，目前有一定掉帧的情况
 */

public class MapActivity extends AppCompatActivity {

    private ImageView ivMap;
    private ImageView ivRoute;
    private HorizontalScrollView mapScroll;
    private RecyclerView mainMap;
    private int realMapWidth;
    private int realMapHeight;
    private int windowWidth;
    private MapAdapter mapAdapter;
    private int lastPosition = -1;
    private boolean isGudie = false;
    private String[] route;
    private Context context;
    private boolean isRunning = false;

    private GravitySensorPosition gravitySensorPosition;
    private Thread refreshPositionThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        context = MapActivity.this;
        ivMap = (ImageView) findViewById(R.id.ivMap);
        ivRoute = (ImageView) findViewById(R.id.ivRoute);
        mapScroll = (HorizontalScrollView) findViewById(R.id.mapScroll);
        mainMap = (RecyclerView) findViewById(R.id.mainMap);
        WindowManager wm = this.getWindowManager();
        windowWidth = wm.getDefaultDisplay().getWidth();
        String tmp = getIntent().getStringExtra("route");
        if ((tmp != null) && (!tmp.equals(""))) {
            route = tmp.split("-");
            isGudie = true;
        } else {
            this.setTitle(getString(R.string.main_page_function2));
        }
        ivMap.post(new Runnable() {
            @Override
            public void run() {
                InitMap();
            }
        });
        ImageView btn1 = (ImageView) findViewById(R.id.ivMapBtn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Message message = new Message();
//                handlerSetStandardDirction.sendMessage(message);
                if (gravitySensorPosition.isRunning && isRunning) {
                    gravitySensorPosition.interrupt();
                    gravitySensorPosition.isRunning = false;
                    refreshPositionThread.interrupt();
                    isRunning = false;
                } else {
                    setRefreshPosition.run();
                }
            }
        });
        Position.resetPosition();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gravitySensorPosition.interrupt();
        refreshPositionThread.interrupt();
    }

    private Runnable setRefreshPosition = new Runnable() {
        @Override
        public void run() {
            gravitySensorPosition = null;
            refreshPositionThread = null;
            gravitySensorPosition = new GravitySensorPosition(getBaseContext());
            gravitySensorPosition.start();
            isRunning = true;
            refreshPositionThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isRunning) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            refreshPositionThread.interrupt();
                            e.printStackTrace();
                        }
                        int position = Position.getPosition();
                        if (position > 0) {
                            Message message = new Message();
                            message.obj = position;
                            handlerSetPositionMark.sendMessage(message);
                        }
                    }
                }
            });
            refreshPositionThread.start();
        }
    };

    //加载地图图片
    private void InitMap() {
        try {
            final int height = ivMap.getHeight();
            int width = height * MapData.map_width / MapData.map_height;
            Picasso.with(this)
                    .load(R.drawable.map2)
                    .resize(width, height)
                    .error(android.R.drawable.ic_menu_close_clear_cancel)
                    .into((ImageView) findViewById(R.id.ivMap), new Callback() {
                        @Override
                        public void onSuccess() {
                            Message message = new Message();
                            handlerSetMapGrid.sendMessage(message);
                        }

                        @Override
                        public void onError() {

                        }
                    });
        } catch (Exception e) {
            Log.d("LoadMapError:", e + "");
            Toast.makeText(getApplicationContext(), "地图加载失败", Toast.LENGTH_SHORT).show();
        }
    }

    //设置地图网格
    private Handler handlerSetMapGrid = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //获得图片真实大小
            realMapHeight = ivMap.getHeight();
            realMapWidth = ivMap.getWidth();
            //获得每个网格的真实大小
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(realMapHeight / MapData.map_height, realMapWidth / MapData.map_width);
            //设置地图内容
            if (!SharedData.isMapReady()) {
                SharedData.parseMapData();
            }
            for (HashMap<String, Object> tmp : SharedData.mapInfo) {
                tmp.put("gridMark", false);
            }
            //建立Adapter
            mapAdapter = new MapAdapter(R.layout.map_grid, SharedData.mapInfo, params, MapActivity.this);
            //设置滑动监听事件，同步RecyclerView和HorizontalSrollableView的滑动
            mainMap.addOnScrollListener(onScrollListenerBoth);
            //设置RecyclerView的布局
            mainMap.setLayoutManager(new StaggeredGridLayoutManager(MapData.map_height, StaggeredGridLayoutManager.HORIZONTAL));
            //设置RecyclerView的Adapter
            mainMap.setAdapter(mapAdapter);
            if (isGudie) {
                //确定用于显示路径的图层的实际大小
                RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(realMapWidth, realMapHeight);
                //调整路径图层的大小
                ivRoute.setLayoutParams(params2);
                //绘制路线
                drawRoute();
            }
            mapAdapter.notifyDataSetChanged();
            mainMap.post(setRefreshPosition);
//            mainMap.post(test);
        }
    };

    //绘制导航路线
    private void drawRoute() {
        //获得每个格子的宽和高
        int grid_width = realMapWidth / MapData.map_width;
        int grid_height = realMapHeight / MapData.map_height;
        //设置圆角的大小（用于平滑路径的连接处，它与路径宽度相同）
        float radius = ((float) (PixelUtil.dp2pixel(this, 5) / 2.0));
        //建立一幅位图，使用较低的色域减小体积
        Bitmap b = Bitmap.createBitmap(realMapWidth, realMapHeight, Bitmap.Config.ARGB_4444);
        //建立画布
        Canvas c = new Canvas(b);
        //建立画笔
        Paint p = new Paint();
        //设置路径颜色为蓝色
        p.setColor(Color.BLUE);
        //设置路径宽度
        p.setStrokeWidth(PixelUtil.dp2pixel(this, 5));
        //循环绘出路径上每两个格子之间的连接线，通过绘制圆形对直线两端进行平滑
        for (int i = 0; i < route.length - 1; i++) {
            int tmp_start = Integer.parseInt(route[i]);
            int tmp_end = Integer.parseInt(route[i + 1]);
            int startX = ((tmp_start / MapData.map_height) * grid_width + grid_width / 2);
            int startY = ((tmp_start % MapData.map_height) * grid_height + grid_height / 2);
            int endX = ((tmp_end / MapData.map_height) * grid_width + grid_width / 2);
            int endY = ((tmp_end % MapData.map_height) * grid_height + grid_height / 2);
            c.drawCircle(startX, startY, radius, p);
            c.drawLine(startX, startY, endX, endY, p);
            c.drawCircle(endX, endY, radius, p);
        }
        //将绘制完成的位图生成Drawable对象
        BitmapDrawable bd = new BitmapDrawable(getResources(), b);
        //置入路径图层
        ivRoute.setBackground(bd);
    }

    //设置定位点的方法，通过它更改Adapter，调整定位点位置并刷新RecyclerView
    private Handler handlerSetPositionMark = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int position = (int) msg.obj;
            HashMap<String, Object> map;
            if (lastPosition > 0) {
                map = SharedData.mapInfo.get(lastPosition);
                map.put("gridMark", false);
                SharedData.mapInfo.set(lastPosition, map);
            }
            map = SharedData.mapInfo.get(position);
            map.put("gridMark", true);
            SharedData.mapInfo.set(position, map);
            lastPosition = position;
            synchronized (this) {
                scrollMap(position);
            }
            mapAdapter.notifyDataSetChanged();
        }
    };

    private void scrollMap(int position) {
        int gridWidth = realMapWidth / MapData.map_width;
        int abs_position = gridWidth * (position / MapData.map_height) + gridWidth / 2;
        int moveX = 0;
        int leftMax = windowWidth / 2;
        int rightMax = realMapWidth - windowWidth / 2;
        if (abs_position < leftMax) {
            mainMap.scrollToPosition(0);
        } else if (abs_position > rightMax) {
            mainMap.scrollToPosition(SharedData.mapInfo.size());
        } else {
            moveX = (position / MapData.map_height - lastPosition / MapData.map_height);
            mainMap.scrollBy(moveX, 0);
        }
        //mapScroll.scrollTo(scrollX,mainMap.getScrollY());
    }

    //滑动监听事件，将RecyclerView的滑动距离传递个HorizontalScrollableView
    RecyclerView.OnScrollListener onScrollListenerBoth = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            mapScroll.scrollBy(dx, dy);
        }
    };

}
