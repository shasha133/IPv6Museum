package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jason on 16-11-7.
 * 用于更改选中展品的Adapter，基于SimpleAdapter
 */

public class ChangeExhibitsAdapter extends SimpleAdapter {

    private ArrayList<Integer> exhibit_no;
    //展品列表
    private ArrayList<Integer> exhibit_selected;
    //选中的展品的列表
    private ArrayList<String> exhibit_imgpath;
    //展品的图片链接
    private Context context;

    //获取选中的展品，用于在生成路线是调用，返回选中展品的数组
    public ArrayList<Integer> getExhibit_selected() {
        return exhibit_selected;
    }

    //用于在修改推荐路线的展品时，预置选定的展品
    public void setExhibit_selected(ArrayList<Integer> exhibit_selected) {
        this.exhibit_selected = exhibit_selected;
    }

    //置入展品编号用于绑定点击事件
    public void setExhibit_no(ArrayList<Integer> exhibit_no) {
        this.exhibit_no = exhibit_no;
    }

    //置入图片链接用于加载
    public void setExhibit_imgpath(ArrayList<String> exhibit_imgpath) {
        this.exhibit_imgpath = exhibit_imgpath;
    }

    //重载入口函数，用于获得Activity的Context和初始化数组
    public ChangeExhibitsAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        exhibit_selected = new ArrayList<>();
    }

    //重载View的刷新事件，绑定点击事件并加载图片
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //获得父View，用于进一步设置View内部的细节
        View view = super.getView(position, convertView, parent);
        //checkBox用于显示是否被选中
        final CheckBox cb = (CheckBox) view.findViewById(R.id.cbExhibitWithMark);
        //如果此展品在被选中的列表里，则打钩，否则不打钩
        if (exhibit_selected.contains(exhibit_no.get(position))) {
            cb.setChecked(true);
        } else {
            cb.setChecked(false);
        }
        //如果设置了展品图片链接，则加载图片
        if (exhibit_imgpath != null) {
            try {
                Picasso.with(context)
                        .load(exhibit_imgpath.get(position))
                        .resize(PixelUtil.dp2pixel(context, 120), PixelUtil.dp2pixel(context, 120))
                        .centerInside()
                        .placeholder(R.drawable.progress_animation)
                        .error(android.R.drawable.ic_menu_close_clear_cancel)
                        .into((ImageView) (view.findViewById(R.id.ivExhibitWithMark)));
            } catch (NullPointerException e) {
                Log.d("LoadPicError:", e + "");
                Toast.makeText(context, "缩略图" + position + "加载失败", Toast.LENGTH_SHORT).show();
            }
        }
        //设置点击事件，将选中的状态置为相反，并更改选中列表
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (exhibit_no != null) {
                    if (cb.isChecked()) {
                        cb.setChecked(false);
                        exhibit_selected.remove(exhibit_selected.indexOf(exhibit_no.get(position)));
                    } else {
                        cb.setChecked(true);
                        exhibit_selected.add(exhibit_no.get(position));
                    }
                }
            }
        });
        return view;
    }
}
