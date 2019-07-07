package cn.edu.xaut.ipv6smartmuseumclient;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jason on 16-11-8.
 * 使用了开源库BaseQuickAdapter，它提供了便捷的RecyclerAdapter的操作方式
 * 新建了一种构造方法，用于传入地图加载后的定位网格大小，并传入Context用于Toast提示
 */

public class MapAdapter extends BaseQuickAdapter {

    private RelativeLayout.LayoutParams params;
    private Context context;

    //LayoutParam用于确定每个网格的大小，由于地图图片为异步加载，所以需要加载完成后获取图片大小并计算每个网格的实际大小
    public MapAdapter(int layoutResId, List data, RelativeLayout.LayoutParams params, Context context) {
        //扩展标准的构造方法之一
        super(layoutResId, data);
        this.params = params;
        this.context = context;
    }

    //重载获取ViewHolder的方法，RecyclerView每次提供一个ViewHolder用于承载自定义Layout，BaseQuickAdapter库将其封装获得一个简洁的convert方法来修改改ViewHolder
    @Override
    protected void convert(BaseViewHolder baseViewHolder, final Object o) {
        baseViewHolder.getConvertView().setLayoutParams(params);
        try {

            //由于数据载体是一个HashMap，所以强转后获取数据
            //当用户位于某个格子，将表职位设为true，依据此判断来选择是否显示位置指示器
            //每次刷新时，如果不显示指示器的格子需要主动设置标记的不可见性
            if ((boolean) ((HashMap<String, Object>) o).get("gridMark")) {
                baseViewHolder.getConvertView().findViewById(R.id.rbGrid).setVisibility(View.VISIBLE);
            } else {
                baseViewHolder.getConvertView().findViewById(R.id.rbGrid).setVisibility(View.INVISIBLE);
            }

            //加载图片并设置点击事件
            if (!((HashMap<String, Object>) o).get("gridPic").equals("")) {
                try {
                    Picasso.with(context)
                            .load((String) ((HashMap<String, Object>) o).get("gridPic"))
                            .resize(PixelUtil.dp2pixel(context, 50), PixelUtil.dp2pixel(context, 50))
                            .centerInside()
                            .placeholder(R.drawable.progress_animation)
                            .error(android.R.drawable.ic_menu_close_clear_cancel)
                            .into((ImageView) (baseViewHolder.getConvertView().findViewById(R.id.ivGrid)));
                } catch (Exception e) {
                    Log.d("LoadPicError:", e + "");
                    Toast.makeText(context, "缩略图加载失败", Toast.LENGTH_SHORT).show();
                }
                //讲ViewHolder转换为View，设置点击事件用于查看讲解信息
                baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("exhibit_no", (Integer) ((HashMap<String, Object>) o).get("gridExhibit"));
                        intent.setClass(context, ExhibitWithSuggestActivity.class);
                        context.startActivity(intent);
                    }
                });
            } else {
                //如果不存在展品的格子，需要主动设置图片为空，否则会导致错位
                ((ImageView) (baseViewHolder.getConvertView().findViewById(R.id.ivGrid))).setImageDrawable(null);
                //取消点击事件
                baseViewHolder.getConvertView().setOnClickListener(null);
            }
        } catch (Exception e) {
            Log.d("Error:", e + "");
        }
    }

}
