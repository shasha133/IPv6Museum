package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 主界面，提供幻灯图片、新闻等等功能
 */

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private OkHttpClient okHttpClient;
    private SliderLayout mainBanner;
    private ListView mainNews;
    private NewsAdapter newsAdapter;
    private Context context;

    //public  static String BASE_URL = "http://202.200.112.108:8080/IPv6Museum";
    public  static String BASE_URL = "http://[2001:da8:270:2021::71]:8082/IPv6Museum";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getBaseContext();
        setContentView(R.layout.activity_main);
        mainBanner = (SliderLayout) findViewById(R.id.mainBanner);
        mainNews = (ListView) findViewById(R.id.mainNews);
        okHttpClient = new OkHttpClient();
        InitBanner();
        InitButton();
        InitNews();
        Message message = new Message();
        handlerCheckIPv6.sendMessage(message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainBanner.startAutoCycle();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainBanner.stopAutoCycle();
    }

    private Handler handlerCheckIPv6 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //"http://[ddec:6fd4:177c::e5e]:8082/IPv6Museum/getStauts"
            Request request = new Request.Builder()
                    .url(BASE_URL+"/getStauts")
                    .build();
            OkHttpClient temp = new OkHttpClient();
            final Message message = new Message();
            temp.newCall(request).enqueue(new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    message.obj = false;
                    handlerIPv6Status.sendMessage(message);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.code() == 204) {
                        message.obj = true;
                        handlerIPv6Status.sendMessage(message);
                    } else {
                        message.obj = false;
                        handlerIPv6Status.sendMessage(message);
                    }
                }
            });
        }
    };

    private Handler handlerIPv6Status = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((boolean) msg.obj) {
                Toast.makeText(context, "网络接入正常", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "网络接入异常", Toast.LENGTH_SHORT).show();
            }
        }
    };

    //用于加载首页新闻
    private void InitNews() {
        if (!SharedData.isNewsInfoReady()) {
            //http://[ddec:6fd4:177c::e5e]:8080/IPv6Museum/getNewsTitle
            Request request = new Request.Builder()
                    .url(BASE_URL+"/getNewsTitle")
                    .build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(context, "网络请求失败", Toast.LENGTH_SHORT).show();
                    Log.d("NetworkError", e + "");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    SharedData.parseNewsJson(response.body().string());
                    Message message = new Message();
                    handlerSetNewsAdapter.sendMessage(message);
                }
            });
            try {
                call.execute();
            } catch (Exception e) {
                Log.d("NetError:", e + "");
            }
//            SharedData.parseNewsJson(Jsons.NewsTitle);
//            Message message = new Message();
//            handlerSetNewsAdapter.sendMessage(message);
        } else {
            Message message = new Message();
            handlerSetNewsAdapter.sendMessage(message);
        }
    }

    private Handler handlerSetNewsAdapter = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            newsAdapter = new NewsAdapter(context, SharedData.news_info, R.layout.news_info, new String[]{"news_title", "news_abstract"}, new int[]{R.id.tvNewsInfoTitle, R.id.tvNewsInfoAbstract});
            newsAdapter.setNews_pic(SharedData.news_pic);
            newsAdapter.setNews_no(SharedData.news_no);
            mainNews.setAdapter(newsAdapter);
            newsAdapter.notifyDataSetChanged();
        }
    };

    //用于设置主页按钮的点击事件
    private void InitButton() {
        try {
            findViewById(R.id.mainButton1).setOnClickListener(onClickListenerMainButton1);
            findViewById(R.id.mainButton2).setOnClickListener(onClickListenerMainButton2);
            findViewById(R.id.mainButton3).setOnClickListener(onClickListenerMainButton3);
            findViewById(R.id.mainButton4).setOnClickListener(onClickListenerMainButton4);
        } catch (NullPointerException e) {
            Log.d("InitButtonError:", e + "");
            Toast.makeText(getApplicationContext(), "初始化按钮失败", Toast.LENGTH_SHORT).show();
        }
    }

    //不同按钮的点击事件
    //展品一览
    View.OnClickListener onClickListenerMainButton1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, AllExhibitsActivity.class);
            startActivity(intent);
        }
    };

    //自助讲解
    View.OnClickListener onClickListenerMainButton2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MapActivity.class);
            startActivity(intent);
        }
    };

    //掌中导游
    View.OnClickListener onClickListenerMainButton3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SelectHowToGuideActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }
    };

    //纪念品商城
    View.OnClickListener onClickListenerMainButton4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ShopActivity.class);
            startActivity(intent);
        }
    };

    //用于初始化图片展示，以下代码参考了作者在github上提供的例子
    private void InitBanner() {
        HashMap<String, String> url_maps = new HashMap<>();
        url_maps.put("陕西省历史博物馆", BASE_URL+"/image/BannerPic/image1.png");
        url_maps.put("陕西古代文明", BASE_URL+"/image/BannerPic/image2.png");
        url_maps.put("兵马俑", BASE_URL+"/image/BannerPic/image3.png");

        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .setOnSliderClickListener(this);

            mainBanner.addSlider(textSliderView);
        }
        mainBanner.setPresetTransformer(SliderLayout.Transformer.Default);
        mainBanner.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        mainBanner.setCustomAnimation(new DescriptionAnimation());
        mainBanner.setDuration(6000);
        mainBanner.addOnPageChangeListener(this);
    }

    //以下为实现SliderLayout的接口所必需的方法
    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
