package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 16-11-6.
 * 重载ArrayAdapter，用于提供点击事件
 */

public class SuggestAdapter extends ArrayAdapter {

    public ArrayList<Integer> suggest_no;
    Context context;

    //设置推荐编号用于确定点击事件
    public void setSuggest_no(ArrayList<Integer> suggest_no) {
        this.suggest_no = suggest_no;
    }

    //获取Activity的Context
    public SuggestAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
    }

    //重载View的刷新事件的处理函数，设置点击事件
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (suggest_no != null) {
                    Intent intent = new Intent();
                    intent.putExtra("suggest_no", suggest_no.get(position));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setClass(context, BuildRouteActivity.class);
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }
}
