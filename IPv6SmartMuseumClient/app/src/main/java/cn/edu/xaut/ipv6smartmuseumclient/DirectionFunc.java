package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by jason on 16-6-11.
 * 用于处理方向传感器的数据的监听类
 * 未来优化方向：TYPE_TYPE_ORIENTATION并不是一种原生的传感器，它是通过一系列计算得到的绝对方向，已经被一个API取代，可以用该API来定期获取方向以减少计算量
 */

public class DirectionFunc implements SensorEventListener {
    public static float CURRENT_DEGREE;

    public DirectionFunc() {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        CURRENT_DEGREE = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
