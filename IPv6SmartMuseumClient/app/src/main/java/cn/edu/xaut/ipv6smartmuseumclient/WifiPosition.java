package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jason on 16-11-17.
 * wifi定位类，用于获取Wifi RSSI及用其进行定位
 *
 * 这些代码暂时是用来获取Wifi信号强度值的
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
}
