package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
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
 * 不带展品推荐的展品讲解Activity
 * 通过Http请求获取展品讲解，加载进Activity
 * 未来优化方向：增加语音讲解功能；理想的方式是将讲解做成Web形态，动态加载，也有助于有多张图片的情况
 */

public class ExhibitWithoutSuggestActivity extends AppCompatActivity {

    private TextView tvExhibitTitle;
    private TextView tvExhibitText;
    private ImageView ivExhibit;
    private OkHttpClient okHttpClient;
    private Context context;
    private int exhibitNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_without_suggest);

        exhibitNo = getIntent().getIntExtra("exhibit_no", 0);

        tvExhibitTitle = (TextView) findViewById(R.id.tvTitleWithoutSuggest);
        tvExhibitText = (TextView) findViewById(R.id.tvTextWithoutSuggest);
        ivExhibit = (ImageView) findViewById(R.id.ivPicWithoutSuggest);

        okHttpClient = new OkHttpClient();
        context = getBaseContext();

        Init();
    }

    private void Init() {
        //"http://[ddec:6fd4:177c::e5e]:8080/IPv6Museum/getMedia?exhibits_id=" + exhibitNo
        Request request = new Request.Builder()
                .url(MainActivity.BASE_URL+"/getMedia?exhibits_id=" + exhibitNo)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //Toast.makeText(context, "网络请求失败", Toast.LENGTH_SHORT).show();
                Log.d("NetworkError", e + "");
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

            String exhibitName = "";
            String fullText = "";

            try {
                JSONObject jsonObject = new JSONObject((String) msg.obj);
                exhibitName = jsonObject.getString("Exhibits_name");
                fullText = jsonObject.getString("Exhibitsinfo_intro");
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "数据错误", Toast.LENGTH_SHORT).show();
            }

            tvExhibitTitle.setText(exhibitName);
            tvExhibitText.setText(fullText);
            try {
                Picasso.with(context)
                        .load(MainActivity.BASE_URL+"/image/ExhibitPic/image" + exhibitNo + ".png")
                        .placeholder(R.drawable.progress_animation)
                        .error(android.R.drawable.ic_menu_close_clear_cancel)
                        .into(ivExhibit);
            } catch (Exception e) {
                Log.d("LoadPicError:", e + "");
                Toast.makeText(context, "图片加载失败", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
