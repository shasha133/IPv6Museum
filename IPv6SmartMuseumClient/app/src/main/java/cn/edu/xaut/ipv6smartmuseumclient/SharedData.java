package cn.edu.xaut.ipv6smartmuseumclient;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 16-11-25.
 * 用于处理Json数据，减少重复作业
 *
 * parseXxxJson是解析Json的方法
 * isXxxReady是检测是否有解析完成的数据的方法，减少计算量
 *
 * 这里解析Json都是用自带的Json类，也可以配合服务端，用Gson之类的快速解析
 */

public class SharedData {

    public static ArrayList<Map<String, Object>> exhibit_name;
    public static ArrayList<Integer> exhibit_no;
    public static ArrayList<String> exhibit_imgpath;

    public static boolean isExhibitInfoReady() {
        return (exhibit_no != null) & (exhibit_name != null) & (exhibit_imgpath != null);
    }

    public static void parseExhibitInfoJson(String json) {
        if (exhibit_no == null) {
            exhibit_no = new ArrayList<>();
        }
        if (exhibit_name == null) {
            exhibit_name = new ArrayList<>();
        }
        if (exhibit_imgpath == null) {
            exhibit_imgpath = new ArrayList<>();
        }
        if (exhibit_name.size() == 0) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    HashMap<String, Object> map = new HashMap<>();
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    exhibit_no.add(jsonObject.getInt("exhibit_no"));
                    exhibit_imgpath.add(MainActivity.BASE_URL + jsonObject.getString("exhibit_imgpath"));
                    map.put("exhibit_name", jsonObject.getString("exhibit_name"));
                    exhibit_name.add(map);


                }
            } catch (JSONException e) {
                Log.d("ParseExhibitJsonError:", e + "");
                exhibit_no = null;
                exhibit_name = null;
                exhibit_imgpath = null;
            }
        }
    }

    public static ArrayList<Map<String, Object>> news_info;
    public static ArrayList<Integer> news_no;
    public static ArrayList<String> news_pic;

    public static boolean isNewsInfoReady() {
        return (news_info != null) & (news_no != null) & (news_pic != null);
    }

    public static void parseNewsJson(String json) {
        if (news_no == null) {
            news_no = new ArrayList<>();
        }
        if (news_pic == null) {
            news_pic = new ArrayList<>();
        }
        if (news_info == null) {
            news_info = new ArrayList<>();
        }
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                HashMap<String, Object> map = new HashMap<>();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                news_no.add(jsonObject.getInt("news_id"));
                String title = jsonObject.getString("news_title");
                if (title.length() > 12) {
                    title = title.substring(0, 11) + "...";
                }
                map.put("news_title", title);
                String abs = jsonObject.getString("news_abstract");
                if (abs.length() > 80) {
                    abs = abs.substring(0, 78) + "...";
                }
                map.put("news_abstract", abs);
                news_pic.add(MainActivity.BASE_URL + jsonObject.getString("news_imgpath"));
                news_info.add(map);
            }
        } catch (JSONException e) {
            Log.d("ParseNewsJsonError:", e + "");
            news_no = null;
            news_pic = null;
            news_info = null;
        }
    }

    public static ArrayList<Integer> suggest_no;
    public static ArrayList<String> suggest_name;

    public static boolean isSuggestReady() {
        return (suggest_no != null) & (suggest_name != null);
    }

    public static void parseSuggestJson(String json) {
        if (suggest_no == null) {
            suggest_no = new ArrayList<>();
        }
        if (suggest_name == null) {
            suggest_name = new ArrayList<>();
        }
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                suggest_no.add(jsonObject.getInt("suggest_no"));
                suggest_name.add(jsonObject.getString("suggest_name"));
            }
        } catch (JSONException e) {
            Log.d("ParseSuggestJsonError:", e + "");
        }
    }

    public static ArrayList<HashMap<String, Object>> mapInfo;
    public static ArrayList<Integer> mapExhibit;

    public static boolean isMapReady() {
        return (mapExhibit != null) & (mapInfo != null);
    }

    //设置Adapter的填充信息中，每个格子的信息，格子编号从0倒MapData.Height*MapData.Weight-1，为对应格子设置展品编号（位于MapData），是否存在图片，以及初始化定位点为不显示
    public static void parseMapData() {
        if (mapInfo == null) {
            mapInfo = new ArrayList<>();
        }
        if (mapExhibit == null) {
            mapExhibit = new ArrayList<>();
        }
        for (int i = 0; i < MapData.map_width; i++) {
            for (int j = 0; j < MapData.map_height; j++) {
                HashMap<String, Object> map = new HashMap<>();
                int grid_exhibit_no = MapData.exhibit_position[j][i];
                map.put("gridExhibit", grid_exhibit_no);
                map.put("gridMark", false);
                //判断，如果存在展品，则设置图片链接，否则为空
                String pic = (grid_exhibit_no == 0) ? "" : exhibit_imgpath.get(exhibit_no.indexOf(grid_exhibit_no));
                map.put("gridPic", pic);
                mapInfo.add(map);
                mapExhibit.add(grid_exhibit_no);
            }
        }
    }

}
