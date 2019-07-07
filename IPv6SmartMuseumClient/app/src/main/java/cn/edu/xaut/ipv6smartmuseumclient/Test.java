package cn.edu.xaut.ipv6smartmuseumclient;

import android.widget.ImageView;

/**
 * Created by gyl on 2018/1/23.
 */

public class Test {
    @Override
    public String toString() {
        return "test [id=" + id + ", color=" + color
                + ", type=" + type + ", integral=" + integral + "]";
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getIntegral() {
        return integral;
    }
    public void setIntegral(String integral) {
        this.integral = integral;
    }
    public int getImageView() {
        return imageView;
    }
    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    private String id;
    private String name;
    private String color;
    private String type;
    private String integral;
    private int imageView;
    private int num;//商品数量
    private int sumIntegral;
    private boolean isChoosed;   //商品是否在购物车中被选中

    public Test(String id,String name,String color, String type, String integral,int imageView) {
        super();
        this.id = id;
        this.name = name;
        this.color = color;
        this.type = type;
        this.integral = integral;
        this.imageView = imageView;
    }
    public Test() {
        super();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSumIntegral() {
        return sumIntegral;
    }

    public void setSumIntegral(int sumIntegral) {
        this.sumIntegral = sumIntegral;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean isChoosed) {
        this.isChoosed = isChoosed;
    }

}

