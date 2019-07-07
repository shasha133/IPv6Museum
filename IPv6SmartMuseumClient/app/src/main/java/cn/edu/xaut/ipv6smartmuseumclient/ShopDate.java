package cn.edu.xaut.ipv6smartmuseumclient;

import java.util.ArrayList;
import java.util.List;

import static cn.edu.xaut.ipv6smartmuseumclient.MainActivity.BASE_URL;

/**
 * Created by gyl on 2018/3/19.
 */

public final  class ShopDate {
    ShopDate(){}
    public static List<ShoppingCartBean> getList() {
        List<ShoppingCartBean> dateList = new ArrayList<>();

//        dateList.add(new ShoppingCartBean("0","古风元素中国风古典书签","普通","普通",30,1,"http://202.200.112.108:8080/imagecut/shopingpictures/shopping1.jpg"));
//        dateList.add(new ShoppingCartBean("1","西安兵马俑博物馆秦代将军铠甲摆件","普通","36cm",199,1,"http://202.200.112.108:8080/imagecut/shopingpictures/shopping2.jpg"));
//        dateList.add(new ShoppingCartBean("2","西安兵马俑遮阳雨伞","普通","100cm",99,1,"http://202.200.112.108:8080/imagecut/shopingpictures/shopping3.jpg"));
//        dateList.add(new ShoppingCartBean("3","复古典中国风黑檀木制手工流苏书签套装","普通","均码",45,1,"http://202.200.112.108:8080/imagecut/shopingpictures/shopping4.jpg"));
//        dateList.add(new ShoppingCartBean("4","故宫海错图书本灯","白色","均码",280,1,"http://202.200.112.108:8080/imagecut/shopingpictures/shopping5.jpg"));
//        dateList.add(new ShoppingCartBean("5","盾牌文物复刻青铜摆件产品","普通","10cm",196,1,"http://202.200.112.108:8080/imagecut/shopingpictures/shopping6.jpg"));

        dateList.add(new ShoppingCartBean("0","古风元素中国风古典书签","普通","普通",30,1,"http://[2001:da8:270:2021::71]:8082/ShopPic/shopping1.jpg"));
        dateList.add(new ShoppingCartBean("1","西安兵马俑博物馆秦代将军铠甲摆件","普通","36cm",199,1,"http://[2001:da8:270:2021::71]:8082/ShopPic/shopping2.jpg"));
        dateList.add(new ShoppingCartBean("2","西安兵马俑遮阳雨伞","普通","100cm",99,1,"http://[2001:da8:270:2021::71]:8082/ShopPic/shopping3.jpg"));
        dateList.add(new ShoppingCartBean("3","复古典中国风黑檀木制手工流苏书签套装","普通","均码",45,1,"http://[2001:da8:270:2021::71]:8082/ShopPic/shopping4.jpg"));
        dateList.add(new ShoppingCartBean("4","故宫海错图书本灯","白色","均码",280,1,"http://[2001:da8:270:2021::71]:8082/ShopPic/shopping5.jpg"));
        dateList.add(new ShoppingCartBean("5","盾牌文物复刻青铜摆件产品","普通","10cm",196,1,"http://[2001:da8:270:2021::71]:8082/ShopPic/shopping6.jpg"));

        return dateList;
    }
}
