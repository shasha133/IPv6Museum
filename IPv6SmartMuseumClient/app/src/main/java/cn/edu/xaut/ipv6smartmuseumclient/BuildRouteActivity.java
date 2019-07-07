package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 用于规划展品路线的Activity
 * 提交Http请求去规划路线，规划成功之后可以点击进入导航，也提供更改展品列表的功能
 * 未来优化方向：加载Activity的方式（更改展品后会遗留上一个Activity的历史，返回键还会回去）
 * 减少规划路线对Activity加载的影响（尝试在生命周期各阶段进行加载）
 */

public class BuildRouteActivity extends AppCompatActivity {

    private TextView tvRouteTitle;
    private TextView tvRouteTime;
    private Button btnRoute1;
    private Button btnRoute2;
    private Button btnRoute3;
    private int suggest_no;
    private ArrayList<Integer> exhibits;
    private ArrayList<Integer> exhibits_position;
    private String route;
    private String suggest_name;
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_route);
        okHttpClient = new OkHttpClient();
        tvRouteTitle = (TextView) findViewById(R.id.tvRouteTitle);
        tvRouteTime = (TextView) findViewById(R.id.tvRouteTime);
        btnRoute1 = (Button) findViewById(R.id.btnRoute1);
        btnRoute2 = (Button) findViewById(R.id.btnRoute2);
        btnRoute3 = (Button) findViewById(R.id.btnRoute3);
        btnRoute1.setOnClickListener(onClickListenerButton1);
        btnRoute2.setOnClickListener(onClickListenerButton2);
        btnRoute3.setOnClickListener(onClickListenerButton3);
        btnRoute3.setClickable(false);
        //用intent的一个extra来判断是推荐路线还是自定义路线，以便显示路线名称
        suggest_no = getIntent().getIntExtra("suggest_no", -1);
        if (suggest_no > 0) {
            suggest_name = SharedData.suggest_name.get(SharedData.suggest_no.indexOf(suggest_no));
            exhibits = IntentUtil.stringToNum(SuggestData.suggest_exhibit[suggest_no - 1]);
        } else {
            suggest_name = getString(R.string.select_selection2);
            exhibits = IntentUtil.stringToNum(getIntent().getStringExtra("exhibits"));
            btnRoute1.setVisibility(View.INVISIBLE);
        }
        Message message = new Message();
        handlerGetTime.sendMessage(message);
        message = new Message();
        handlerBuildRoute.sendMessage(message);
    }

    //获取运行时间，用展品数量乘平均事件获得预计时间
    private Handler handlerGetTime = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvRouteTime.setText(exhibits.size() * 2 + getString(R.string.minute));
            tvRouteTitle.setText(getString(R.string.route) + suggest_name);
        }
    };

    //如果路线规划完成，则可以点击开始导航的按钮，默认不能点击
    private Handler handlerConfirmRoute = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            btnRoute3.setClickable(true);
        }
    };

    //用于生成路线
    private Handler handlerBuildRoute = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            if (!SharedData.isMapReady()) {
                SharedData.parseMapData();
            }
            //所选的展品位置的列表
            exhibits_position = new ArrayList<>();
            //将展品列表换算微展品位置，填充进列表
            for (int tmp : exhibits) {
                exhibits_position.add(SharedData.mapExhibit.indexOf(tmp));
            }
            //构建Http请求
            //"http://[ddec:6fd4:177c::e5e]:8080/IPv6Museum/GetPath?exhibits=" + IntentUtil.numToThree(exhibits)
            String url = MainActivity.BASE_URL + "/GetPath?exhibits=" + IntentUtil.numToThree(exhibits);
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            //通过OkHttp的回调，异步进行请求
            //注意，这个回调并不在UI线程里，不能用来更新界面，要更新界面需要用Handler
            call.enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    //Toast.makeText(context, "网络请求失败", Toast.LENGTH_SHORT).show();
                    Log.d("NetworkError", e + "");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    //route = IntentUtil.numToString(exhibits_position);
                    String body = response.body().string();
                    route = IntentUtil.getRightRoute(body);
                    //比如这里
                    Message message = new Message();
                    handlerConfirmRoute.sendMessage(message);
                }
            });
            try {
                call.execute();
            } catch (Exception e) {
                Log.d("NetError:", e + "");
            }
        }
    };

    //查看推荐路线信息的点击事件，通过Intent传递推荐路线的编号
    View.OnClickListener onClickListenerButton1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(BuildRouteActivity.this, ImformationActivity.class);
            startActivity(intent);
        }
    };

    //更改路线的点击事件，通过Intent传递展品数组字符串，返回更改后的展品数组字符串
    View.OnClickListener onClickListenerButton2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("exhibits", IntentUtil.numToString(exhibits));
            intent.setClass(BuildRouteActivity.this, ChangeExhibitsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }
    };

    //开始参观的点击事件，规划路线并将有序的展品需要数组组织成字符串，通过Intent传递给MapActivity
    View.OnClickListener onClickListenerButton3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(BuildRouteActivity.this, MapActivity.class);
            intent.putExtra("route", route);
            //intent.putExtra("route", route);
            startActivity(intent);
        }
    };

}
