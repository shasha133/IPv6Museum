package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;

/**
 * Created by jason on 16-11-3.
 * 此类用于将各类所需数据转化为Picasso所需要的像素值
 */

public class PixelUtil {

    //用于将XML中的dp数据转化为像素大小
    public static int dp2pixel(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

}
