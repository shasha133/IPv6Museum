package cn.edu.xaut.ipv6smartmuseumclient;

import java.util.Map;

/**
 * Created by jason on 16-11-17.
 * 用于提供位置信息的存储和调用
 * 未来优化方向：用更合理的方法将位置可行化
 */

public class Position {

    private static int position = -1;

    public static int getPosition() {
        return position;
    }

    public static void resetPosition() {
        Position.position = -1;
    }

    //通过格子号来设置位置的方法，这里强行讲不合理的格子号整理为可行的
    public static void setPosition(int position) {
        int temp = position;
        while (temp < MapData.map_height) {
            temp += MapData.map_height;
        }
        while (temp > MapData.map_height * (MapData.map_width - 1)) {
            temp -= MapData.map_height;
        }
        while (temp % MapData.map_height < 1) {
            temp += 1;
        }
        while (temp % MapData.map_height > MapData.map_height - 2) {
            temp -= 1;
        }

        Position.position = temp;
    }

    //通过坐标来社ing格子号的方法，同样是强行让数值合理
    public static void setPositionByCoordinate(double positionX, double positionY) {

        while (positionX < MapData.grid_width) {
            positionX += MapData.grid_width;
        }
        while (positionX > MapData.grid_width * (MapData.map_width)) {
            positionX -= MapData.grid_width;
        }
        while (positionY < MapData.grid_height) {
            positionY += MapData.grid_height;
        }
        while (positionY > MapData.grid_height * (MapData.map_height)) {
            positionY -= MapData.grid_height;
        }
        int gridX = (int) Math.floor(positionX / MapData.grid_width);
        int gridY = MapData.map_height - (int) Math.floor(positionY / MapData.grid_height);
        setPosition(gridY + gridX * MapData.map_height);
    }

}
