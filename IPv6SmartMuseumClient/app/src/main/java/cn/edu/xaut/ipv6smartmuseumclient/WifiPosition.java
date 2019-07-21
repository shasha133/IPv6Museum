package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jason on 16-11-17.
 * wifi定位类，用于获取Wifi RSSI及用其进行定位
 *
 * 这些代码暂时是用来获取Wifi信号强度值的！！！
 */

public class WifiPosition {

    private static WifiManager wifiManager;
    private static WifiReceiver wifiReceiver;
    private static HashMap<String, String> mapMac;
    private ArrayList<HashMap<String, String>> listContent;
    private Context context;

    //这里需要在Activity中加入申请权限的部分
    //WifiManager本身是一个单例模式，所以只需初始化一次
    //WifiReceiver作为一个事件监听器，采用单例模式可以避免重复监听和冲突的产生
    public WifiPosition(Context context) {
        this.context = context;

        if (wifiManager == null) {
            wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        }
        if (wifiReceiver == null) {
            wifiReceiver = new WifiReceiver();
        }
        if (mapMac == null) {
            initMapMac();
        }
    }

    private static void initMapMac() {
        mapMac = new HashMap<>();
        mapMac.put("6c:3b:6b:44:32:d3", "1");
        mapMac.put("6c:3b:6b:48:bd:ad", "2");
        mapMac.put("6c:3b:6b:48:c0:5f", "3");
        mapMac.put("6c:3b:6b:48:c3:3e", "4");
    }

    private void OpenWifi() {
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
    }

    private void CloseWifi() {
        if (wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }

    //进行一次Wifi信号扫描
    public void startScan() {
        if ((wifiManager != null) && (wifiReceiver != null)) {
            OpenWifi();
            context.registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
            wifiManager.startScan();
        }
    }

    //继承一个广播接收器，接收事件广播
    private final class WifiReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            listContent.clear();
            HashMap<String, String> usefulInfo;
            for (ScanResult tmp : scanResults) {
                if (tmp.SSID.equals("EXP_AP")) {
                    String mac = tmp.BSSID;
                    String no = mapMac.get(mac);
                    if (no == null) {
                        no = "0";
                    }
                    usefulInfo = new HashMap<>();
                    usefulInfo.put("apNo", no);
                    usefulInfo.put("apRSSI", tmp.level + "");
                    listContent.add(usefulInfo);
                }
            }
            //将采集到的Wifi信号以AP编号排序
            Collections.sort(listContent, new Comparator<Map<String, String>>() {
                @Override
                public int compare(Map<String, String> o1, Map<String, String> o2) {
                    int val1 = Integer.parseInt(o1.get("tvNo"));
                    int val2 = Integer.parseInt(o2.get("tvNo"));
                    return (val1 < val2 ? -1 : (val1 == val2 ? 0 : 1));
                }
            });
            //在这里设置位置信息，这里需要在服务器端请求位置信息，放在okHttp的onSuccess回调中
            Position.setPosition(1);
            context.unregisterReceiver(wifiReceiver);
        }
    }

    private static final double A_Value=27.24;/**A - 发射端和接收端相隔1米时的信号强度*/
    private static final double n_Value=2.599;/** n - 环境衰减因子*/

    /**
     * 根据Rssi获得返回的距离,返回数据单位为m
     * @param rssi
     * 功能：根据rssi计算距离
     */
    double h0=1.25;
    double h = 0.44;
    List<Double> Distance = new ArrayList<Double>();
    List<List<Double>>l = new ArrayList<List<Double>>();
    @SuppressWarnings("unchecked")
    public void getDistance(List<Double> data1)throws IOException {

        for(int i =0;i<data1.size();i++){
            double iRssi = data1.get(i);
            double rss = Math.abs(iRssi);
            double power = (rss-A_Value)/(10*n_Value);
            double distance = Math.pow(10,power);         //rss计算出来的距离
            double d1 = Math.pow(distance,2);
            double h1 = h - h0;
            double h2 = Math.pow(h1,2);
            double d3 = d1-h2;
            double finald =Math.sqrt(d3);            //最终距离存在Distance
            Distance.add(finald);
        }
        IdentityHashMap<Double,Integer> map =new IdentityHashMap<Double,Integer>();
        for (int i1 = 0; i1 < Distance.size(); i1++) {

            map.put(Distance.get(i1),i1); // 将值和下标存入Map
        }

        Collections.sort(Distance) ;             //对rss进行由小到大排序

        List newList = Distance.subList(0,3);         //取前三个最小的值

        /**
         * 现在newList中存放的是距离d
         * l中存放的是坐标
         * 首先定义一个列表存放计算后的距离
         * for循环三次
         * d中存初始距离
         */
        List<Double> D = new ArrayList<Double>();         //D中存距离
        for(int i1 = 0;i1 <3 ;i1++){
            Object d1 = newList.get(i1);
            Double d11 =  Double.parseDouble(d1.toString());
            D.add(d11);
        }

        /**
         * 拿出AP坐标放入XY里面
         */
        List<Double> L = new ArrayList<Double>();
        List<Double> XY = new ArrayList<Double>();
        L = l.get(0);
        for(int i=0;i<2;i++){
            Double xy1 = L.get(i);
            XY.add(xy1);
        }
        L = l.get(1);
        for(int i=0;i<2;i++){
            Double xy2 = L.get(i);
            XY.add(xy2);
        }
        L = l.get(2);
        for(int i=0;i<2;i++){
            Double xy3 = L.get(i);
            XY.add(xy3);
        }

        /**
         * 计算最终坐标
         *现在坐标在XY   距离d在Distance里面
         *先计算距离系数
         */
        double d1 = Distance.get(0);
        double d2 = Distance.get(1);
        double d3 = Distance.get(2);

        double x1 = XY.get(0);
        double y1 = XY.get(1);
        double x2 = XY.get(2);
        double y2 = XY.get(3);
        double x3 = XY.get(4);
        double y3 = XY.get(5);

        intresect(x1,y1,d1,x2,y2,d2,x3,y3,d3);
        solution(x1,y1,d1,x2,y2,d2,x3,y3,d3);

    }

    private void solution(double x1, double y1, double r1, double x2, double y2, double r2, double x3, double y3, double r3) throws IOException {
        // TODO Auto-generated method stub


        double x, y;

        double d12 = 1/(r1+r2);
        double d23 = 1/(r2+r3);
        double d31 = 1/(r3+r1);
        double dd = d12+d23+d31;
        List<Double> local = new ArrayList<Double>();         //存放最终坐标点

        //如果三圆两两相交
        boolean Intersect = (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < Math.pow(r1
                + r2, 2)
                && (Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2)) < Math.pow(r2
                + r3, 2)
                && (Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2)) < Math.pow(r3
                + r1, 2);

        if (Intersect) {
            double[] D = intresect(x1, y1, r1, x2, y2, r2, x3, y3, r3);// 圆1和圆2的两个交点
            // 选出离圆3最近的交点

            if ((Math.pow(D[0] - x3, 2) + Math.pow(D[1] - y3, 2)) < Math.pow(r3, 2)) {// 三圆有公共区域
                System.out.println("三圆有公共区域");
                double xd = D[0];
                double yd = D[1];
                double[] E = intresect(x2, y2, r2, x3, y3, r3, x1, y1, r1);
                double xe = E[0];
                double ye = E[1];
                double[] F = intresect(x1, y1, r1, x3, y3, r3, x2, y2, r2);
                double xf = F[0];
                double yf = F[1];

                //传统求三角形质心
                //x = (xd + xe + xf) / 3;
                //y = (yd + ye + yf) / 3;

                double X =(xd*d12+xe*d23+xf*d31)/dd;
                double Y = (yd*d12+ye*d23+yf*d31)/dd;
                local.add(X);
                local.add(Y);
                System.out.print(local);
            } else if((Math.pow(D[0] - x3, 2) + Math.pow(D[1] - y3, 2)) > Math.pow(r3, 2)){// 三圆两两相交，没有公共区域
                System.out.println("三圆两两相交，没有公共区域");
                //取两两圆交点的中点，形成三角形，求内心
                double xd = D[2];
                double yd = D[3];
                double[] E = intresect(x2, y2, r2, x3, y3, r3, x1, y1, r1);
                double xe = E[2];
                double ye = E[3];
                double[] F = intresect(x1, y1, r1, x3, y3, r3, x2, y2, r2);
                double xf = F[2];
                double yf = F[3];
                double X =(xd*d12+xe*d23+xf*d31)/dd;
                double Y = (yd*d12+ye*d23+yf*d31)/dd;
                local.add(X);
                local.add(Y);
            }else{//三圆交于一点
                x = D[0];
                y = D[1];
                local.add(x);
                local.add(y);
            }

        } else {
            //其中两圆没有交点，不予处理
            System.out.println("其中两圆没有交点，不予处理");
        }

    }

    private double[] intresect(double x1, double y1, double r1, double x2,
                               double y2, double r2, double x3, double y3, double r3) {
        // TODO Auto-generated method stub
        double a, b, c;

        // 判别式的值
        double delta = -1;
        // x的两个根 x_1 , x_2
        // y的两个根 y_1 , y_2
        double x_1 = 0, x_2 = 0, y_1 = 0, y_2 = 0;

        // 如果 y1!=y2
        if (y1 != y2) {
            //两个圆相减得到相交的直线方程y = A-Bx

            double A = (x1 * x1 - x2 * x2 + y1 * y1 - y2 * y2 + r2 * r2 - r1
                    * r1)
                    / (2 * (y1 - y2));
            double B = (x1 - x2) / (y1 - y2);
            //将得到的直线方程带入其中一个圆里面，化为ax^2+bx+c = r^2,得到系数值a,b,c
            a = 1 + B * B;
            b = -2 * (x1 + (A - y1) * B);
            c = x1 * x1 + (A - y1) * (A - y1) - r1 * r1;

            // 下面使用判定式 判断是否有解
            delta = b * b - 4 * a * c;

            if (delta > 0) {
                x_1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                x_2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                y_1 = A - B * x_1;
                y_2 = A - B * x_2;
            } else if (delta == 0) {
                x_1 = x_2 = -b / (2 * a);
                y_1 = y_2 = A - B * x_1;
            } else {
                System.err.println("两个圆不相交");
                return null;
            }
        } else if (x1 != x2) {

            // 当y1=y2时，x的两个解相等
            x_1 = x_2 = (x1 * x1 - x2 * x2 + r2 * r2 - r1 * r1)
                    / (2 * (x1 - x2));

            a = 1;
            b = -2 * y1;
            c = y1 * y1 - r1 * r1 + (x_1 - x1) * (x_1 - x1);

            delta = b * b - 4 * a * c;

            if (delta > 0) {
                y_1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                y_2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            } else if (delta == 0) {
                y_1 = y_2 = -b / (2 * a);
            } else {
                System.err.println("两个圆不相交");
            }
        } else {
            System.out.println("无解");
        }

        double middle_x=(x_1+x_2)/2;
        double middle_y=(y_1+y_2)/2;
        if ((Math.pow(x_1 - x3, 2) + Math.pow(y_1 - y3, 2)) > (Math.pow(x_2
                - x3, 2) + Math.pow(y_2 - y3, 2)))
            return  new double[] { x_2, y_2,middle_x,middle_y };
        else
            return new double[] { x_1, y_1,middle_x,middle_y };

    }
}
