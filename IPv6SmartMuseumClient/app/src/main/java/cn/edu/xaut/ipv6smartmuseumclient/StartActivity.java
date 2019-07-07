package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jason on 16-10-31.
 * 启动页面，展示Logo并自动切换到主页
 */

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //加载Logo
        Picasso.with(this)
                .load(R.drawable.logo)
                .resize(PixelUtil.dp2pixel(this, 150), PixelUtil.dp2pixel(this, 150))
                .centerCrop()
                .error(android.R.drawable.ic_menu_close_clear_cancel)
                .into((ImageView) findViewById(R.id.startLogo));
        //切换Activity的计划任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(StartActivity.this, MainActivity.class);
                //设置新Activity位于顶端，避免返回键将其返回，同时节约内存
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                StartActivity.this.finish();
            }
        };
        //启动计划任务，500ms后切换倒主页
        new Timer().schedule(timerTask, 500);

        SharedData.parseExhibitInfoJson(Jsons.ExhibitInfo);
    }

}
