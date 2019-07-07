package cn.edu.xaut.ipv6smartmuseumclient;

/**
 * Created by jason on 16-11-7.
 * 地图信息，MapActivity根据此数据生成地图
 */

public class MapData {

    public static int map_width = 15;
    //地图横向的网格数量
    public static int map_height = 10;
    //地图纵向的网格数量
    public static double grid_width = 0.6;
    //实际的网格宽度
    public static double grid_height = 0.6;
    //实际的网格高度

    public static int[][] exhibit_position = {
            {0, 0, 4, 0, 0, 8, 0, 0, 12, 0, 0, 16, 0, 0, 18},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 6, 0, 0, 0, 0, 13, 0, 0, 0, 0, 0, 19},
            {2, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0},
            {0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20},
            {3, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0},
            {0, 0, 5, 0, 0, 9, 0, 0, 0, 0, 0, 17, 0, 0, 0}
    };

}
