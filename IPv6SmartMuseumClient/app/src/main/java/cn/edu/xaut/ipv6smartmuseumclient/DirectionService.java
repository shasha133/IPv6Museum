package cn.edu.xaut.ipv6smartmuseumclient;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;

/**
 * 方向传感器的服务，用于注册监听器持续获取方向
 */

public class DirectionService extends Service {
    public static boolean FLAG = false;

    private SensorManager mSensorManager;// 传感器服务
    private DirectionFunc detector = null;// 传感器监听对象

    public DirectionService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        FLAG = true;// 标记为服务正在运行
        // 创建监听器类，实例化监听对象
        detector = new DirectionFunc();
        // 获取传感器的服务，初始化传感器
        mSensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        // 注册传感器，注册监听器
        mSensorManager.registerListener(detector, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_UI);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        FLAG = false;// 服务停止
        if (detector != null) {
            mSensorManager.unregisterListener(detector);
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
