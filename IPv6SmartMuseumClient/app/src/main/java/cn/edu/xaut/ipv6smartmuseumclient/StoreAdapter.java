package cn.edu.xaut.ipv6smartmuseumclient;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gyl on 2018/1/23.
 */

public class StoreAdapter extends BaseAdapter {
    private List<ShoppingCartBean> mData;
    private LayoutInflater mInflater;
    StoreAdapter(LayoutInflater inflater,List<ShoppingCartBean> data){
        mInflater = inflater;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获得ListView中的view
        View viewnew = mInflater.inflate(R.layout.iterm_store_list, null);
        //获得对象
        ShoppingCartBean tmp = mData.get(position);
        //获得自定义布局中每一个控件的对象。
        ImageView imagePhoto = (ImageView) viewnew.findViewById(R.id.store_imag);
        TextView name = (TextView) viewnew.findViewById(R.id.store_name);
        TextView value = (TextView) viewnew.findViewById(R.id.store_value);

        name.setText(tmp.getShoppingName());
        value.setText(""+tmp.getPrice());
        try {
            Picasso.with(mInflater.getContext())
                    .load(tmp.getImageUrl())
                    .resize(PixelUtil.dp2pixel(mInflater.getContext(), 100), PixelUtil.dp2pixel(mInflater.getContext(), 100))
                    .centerInside()
                    .placeholder(R.drawable.progress_animation)
                    .error(android.R.drawable.ic_menu_close_clear_cancel)
                    .into(imagePhoto);
        } catch (Exception e) {
            Log.d("LoadPicError:", e + "");
            Toast.makeText(mInflater.getContext(), "缩略图" + tmp.getImageUrl() + position + "加载失败", Toast.LENGTH_SHORT).show();
        }
        return viewnew ;
    }

    public void add(ShoppingCartBean date){
        mData.add(date);
        notifyDataSetChanged();
    }
}
