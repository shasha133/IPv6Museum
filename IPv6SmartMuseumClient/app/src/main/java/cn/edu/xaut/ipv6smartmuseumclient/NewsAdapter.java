package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jason on 16-11-4.
 * 重载了SimpleAdapter，提供绑定“查看全文”的点击事件
 */

public class NewsAdapter extends SimpleAdapter {

    private ArrayList<Integer> news_no;
    //新闻编号
    private ArrayList<String> news_pic;
    //新闻缩略图
    private Context context;

    public void setNews_pic(ArrayList<String> news_pic) {
        this.news_pic = news_pic;
    }

    //通过传递新闻编号列表来对查看全文进行绑定
    public void setNews_no(ArrayList<Integer> news_no) {
        this.news_no = news_no;
    }

    public NewsAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
    }

    //得到新闻编号列表后，每次刷新这个ListView时绑定点击事件
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        //如果设置的图片链接，则加载图片
        if (news_pic != null) {
            try {
                Picasso.with(context)
                        .load("http://[2001:da8:270:2021::71]:8082/imagecut/newspictures/1.jpg")
                        .resize(PixelUtil.dp2pixel(context, 100), PixelUtil.dp2pixel(context, 100))
                        .centerInside()
                        .placeholder(R.drawable.progress_animation)
                        .error(android.R.drawable.ic_menu_close_clear_cancel)
                        .into((ImageView) view.findViewById(R.id.ivNewsInfoPic));
            } catch (Exception e) {
                Log.d("LoadPicError:", e + "");
                Toast.makeText(context, "缩略图" + position + "加载失败", Toast.LENGTH_SHORT).show();
            }
        }
        final TextView tvGetFullNews = (TextView) view.findViewById(R.id.tvGetFullNews);
        tvGetFullNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (news_no != null) {
                    Intent intent = new Intent();
                    intent.putExtra("news_no", news_no.get(position));
                    intent.putExtra("news_pic", news_pic.get(position));
                    intent.setClass(context, NewsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }

}
