package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
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
 * 带展品推荐的展品讲解Activity
 * 未来优化方向：与不带讲解的类似，并且推荐应该能够以一定形式加入选中的展品列表并且再一次规划路线
 */

public class ExhibitWithSuggestActivity extends AppCompatActivity {

    private TextView tvExhibitTitle;
    private TextView tvExhibitText;
    private ImageView ivExhibit;
    private TextView tvSuggest1;
    private TextView tvSuggest2;
    private ImageView ivSuggest1;
    private ImageView ivSuggest2;
    private OkHttpClient okHttpClient;
    private Context context;
    private int exhibitNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_with_suggest);

        exhibitNo = getIntent().getIntExtra("exhibit_no", 0);

        tvExhibitTitle = (TextView) findViewById(R.id.tvTitleWithSuggest);
        tvExhibitText = (TextView) findViewById(R.id.tvTextWithSuggest);
        ivExhibit = (ImageView) findViewById(R.id.ivPicWithSuggest);

        tvSuggest1 = (TextView) findViewById(R.id.tvSuggest1);
        tvSuggest2 = (TextView) findViewById(R.id.tvSuggest2);
        ivSuggest1 = (ImageView) findViewById(R.id.ivSuggest1);
        ivSuggest2 = (ImageView) findViewById(R.id.ivSuggest2);

        okHttpClient = new OkHttpClient();
        context = getBaseContext();

        Init();
    }

    private void Init() {

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
            int Suggest1 = (((exhibitNo - 1) > 0) ? exhibitNo - 1 : SharedData.exhibit_no.size());
            int Suggest2 = (((exhibitNo + 1) < SharedData.exhibit_no.size()) ? exhibitNo + 1 : 1);

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

            tvSuggest1.setText((String) SharedData.exhibit_name.get(SharedData.exhibit_no.indexOf(Suggest1)).get("exhibit_name"));
            tvSuggest2.setText((String) SharedData.exhibit_name.get(SharedData.exhibit_no.indexOf(Suggest2)).get("exhibit_name"));

            try {
                Picasso.with(context)
                        .load(MainActivity.BASE_URL+"/image/ExhibitIcon/image" + Suggest1 + ".png")
                        .resize(PixelUtil.dp2pixel(context, 100), PixelUtil.dp2pixel(context, 100))
                        .centerInside()
                        .placeholder(R.drawable.progress_animation)
                        .error(android.R.drawable.ic_menu_close_clear_cancel)
                        .into(ivSuggest1);
                Picasso.with(context)
                        .load(MainActivity.BASE_URL+"/image/ExhibitIcon/image" + Suggest2 + ".png")
                        .resize(PixelUtil.dp2pixel(context, 100), PixelUtil.dp2pixel(context, 100))
                        .centerInside()
                        .placeholder(R.drawable.progress_animation)
                        .error(android.R.drawable.ic_menu_close_clear_cancel)
                        .into(ivSuggest2);
            } catch (Exception e) {
                Log.d("LoadPicError:", e + "");
                Toast.makeText(context, "图片加载失败", Toast.LENGTH_SHORT).show();
            }
        }

    };
}
