package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * 选择如何导游的Activity
 * 主要是绑定点击事件
 */

public class SelectHowToGuideActivity extends AppCompatActivity {

    //加载对应的图片
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_how_to_guide);

        Picasso.with(SelectHowToGuideActivity.this)
                .load(R.drawable.background)
                .fit()
                .centerCrop()
                .error(android.R.drawable.ic_menu_close_clear_cancel)
                .into((ImageView) findViewById(R.id.ivSelectHowToGuide));

        Picasso.with(SelectHowToGuideActivity.this)
                .load(R.drawable.selection1)
                .resize(PixelUtil.dp2pixel(this, 150), PixelUtil.dp2pixel(this, 150))
                .centerInside()
                .error(android.R.drawable.ic_menu_close_clear_cancel)
                .into((ImageView) findViewById(R.id.ivSelect1));

        Picasso.with(SelectHowToGuideActivity.this)
                .load(R.drawable.selection2)
                .resize(PixelUtil.dp2pixel(this, 150), PixelUtil.dp2pixel(this, 150))
                .centerInside()
                .error(android.R.drawable.ic_menu_close_clear_cancel)
                .into((ImageView) findViewById(R.id.ivSelect2));
        try {
            findViewById(R.id.selectBtn1).setOnClickListener(onClickListenerSuggestBtn1);
            findViewById(R.id.selectBtn2).setOnClickListener(onClickListenerSuggestBtn2);
        } catch (Exception e) {
            Log.d("Error:", e + "");
        }

    }

    //推荐路线的点击事件
    View.OnClickListener onClickListenerSuggestBtn1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(SelectHowToGuideActivity.this, SuggestActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }
    };

    //自定义路线的点击事件
    View.OnClickListener onClickListenerSuggestBtn2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(SelectHowToGuideActivity.this, ChangeExhibitsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }
    };

}
