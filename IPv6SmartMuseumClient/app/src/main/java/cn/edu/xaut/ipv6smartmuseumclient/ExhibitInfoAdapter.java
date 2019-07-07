package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jason on 16-11-4.
 * 重载了SimpleAdapter，绑定点击事件
 */

public class ExhibitInfoAdapter extends SimpleAdapter {

    private ArrayList<Integer> exhibit_no;
    //展品编号列表
    private ArrayList<String> exhibit_imgpath;
    //展品图片链接的列表
    private Context context;

    //传递缩略图URL
    public void setExhibit_imgpath(ArrayList<String> exhibit_imgpath) {
        this.exhibit_imgpath = exhibit_imgpath;
    }

    //通过传递新闻编号列表来对查看全文进行绑定
    public void setExhibit_no(ArrayList<Integer> exhibit_no) {
        this.exhibit_no = exhibit_no;
    }

    public ExhibitInfoAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
    }

    //得到展品编号列表后，每次刷新这个ListView时获取图片并绑定点击事件
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        final View view = super.getView(position, convertView, parent);
        if (exhibit_imgpath != null) {
            try {
                Picasso.with(context)
                        .load(exhibit_imgpath.get(position))
                        .resize(PixelUtil.dp2pixel(context, 120), PixelUtil.dp2pixel(context, 120))
                        .centerInside()
                        .placeholder(R.drawable.progress_animation)
                        .error(android.R.drawable.ic_menu_close_clear_cancel)
                        .into((ImageView) (view.findViewById(R.id.ivExhibitGrid)));
            } catch (NullPointerException e) {
                Log.d("LoadPicError:", e + "");
                Toast.makeText(context, "缩略图" + position + "加载失败", Toast.LENGTH_SHORT).show();
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exhibit_no != null) {
                    Intent intent = new Intent();
                    intent.putExtra("exhibit_no", exhibit_no.get(position));
                    intent.setClass(context, ExhibitWithoutSuggestActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }

}
