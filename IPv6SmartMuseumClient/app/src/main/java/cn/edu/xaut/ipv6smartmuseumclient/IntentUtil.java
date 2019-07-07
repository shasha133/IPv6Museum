package cn.edu.xaut.ipv6smartmuseumclient;

import java.util.ArrayList;

/**
 * Created by jason on 16-11-16.
 * 用于执行数组-字符串和字符串-数组的工作，便于Intent传递信息
 */

public class IntentUtil {

    //数字列表转换成数字-数字的格式的字符串
    public static String numToString(ArrayList<Integer> num) {
        if (num != null) {
            String temp = num.get(0) + "";
            for (int i = 1; i < num.size(); i++) {
                temp += "-";
                temp += num.get(i);
            }
            return temp;
        } else {
            return null;
        }
    }

    //为了路径规划接口准备的方法，生成“001-002-003-010”这种形式的字符串
    public static String numToThree(ArrayList<Integer> num) {
        if (num != null) {
            String tmpNum = num.get(0) + "";
            while (tmpNum.length() < 3) {
                tmpNum = "0" + tmpNum;
            }
            String temp = tmpNum;
            for (int i = 1; i < num.size(); i++) {
                tmpNum = num.get(i) + "";
                while (tmpNum.length() < 3) {
                    tmpNum = "0" + tmpNum;
                }
                temp += "-";
                temp += tmpNum;
            }
            return temp;
        } else {
            return null;
        }
    }

    //用于把数字-数字形式的字符串转换成数字列表
    public static ArrayList<Integer> stringToNum(String string) {
        if (string != null) {
            ArrayList<Integer> temp = new ArrayList<>();
            String[] split = string.split("-");
            for (String num : split) {
                temp.add(Integer.parseInt(num));
            }
            return temp;
        } else {
            return null;
        }
    }

    //用于处理返回的路线数据
    public static String getRightRoute(String route) {
        if (route != null) {
            route = route.substring(0, route.length() - 1);
            route = route.replace(",", "-");
            return route;
        } else {
            return null;
        }
    }

}
