package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 查看新闻全文的Activity
 * 未来优化方向：同样希望可以做成Web形式
 */

public class NewsActivity extends AppCompatActivity {

    private TextView tvNewsTitle;
    private ImageView ivNews;
    private TextView tvNewsText;
    private Context context;
    private int newsNo;
    private String newPic;
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        newsNo = getIntent().getIntExtra("news_no", 1);
        newPic = getIntent().getStringExtra("news_pic");
        tvNewsTitle = (TextView) findViewById(R.id.tvNewsTitle);
        tvNewsText = (TextView) findViewById(R.id.tvNewsText);
        ivNews = (ImageView) findViewById(R.id.ivNews);

        context = getBaseContext();
        okHttpClient = new OkHttpClient();

        Init();
    }

    private void Init() {
        Request request = new Request.Builder()
                .url(MainActivity.BASE_URL+"/getNews?news_id=" + newsNo)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context, "网络请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = new Message();
                message.obj = response.body().string();
                handlerSetContent.sendMessage(message);
            }
        });
        try {
            call.execute();
        } catch (Exception e) {
            Log.d("NetError:", e + "");
        }
    }

    private Handler handlerSetContent = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String newsTitle = "";
            String fullText = "";

            try {
                JSONObject jsonObject = new JSONObject((String) msg.obj);
                newsTitle = jsonObject.getString("news_title");
                fullText = jsonObject.getString("news_context");
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "数据错误", Toast.LENGTH_SHORT).show();
            }

            try {
                Picasso.with(context)
                        .load(newPic)
                        .resize(PixelUtil.dp2pixel(context, 200), PixelUtil.dp2pixel(context, 200))
                        .placeholder(R.drawable.progress_animation)
                        .error(android.R.drawable.ic_menu_close_clear_cancel)
                        .into(ivNews);
            } catch (Exception e) {
                Log.d("LoadPicError:", e + "");
                Toast.makeText(context, "图片加载失败", Toast.LENGTH_SHORT).show();
            }

            tvNewsTitle.setText(newsTitle);
            tvNewsText.setText(fullText);
        }
    };
}
