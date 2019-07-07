package cn.edu.xaut.ipv6smartmuseumclient;

/**
 * Created by AYD on 2016/11/22.
 * <p>
 * 购物车
 */
public class ShoppingCartBean {

    private String id;
    private String imageUrl;
    private String shoppingName;

    private String size;
    private String attribute;

    private double price;

    public boolean isChoosed;
    public boolean isCheck = false;
    private int count;

    public ShoppingCartBean(String id, String shoppingName, String attribute, String size,
                            double price, int count,String imageUrl) {
        this.id = id;
        this.shoppingName = shoppingName;
        this.attribute = attribute;
        this.size = size;
        this.price = price;
        this.count = count;
        this.imageUrl = imageUrl;

    }
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean choosed) {
        isChoosed = choosed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShoppingName() {
        return shoppingName;
    }

    public void setShoppingName(String shoppingName) {
        this.shoppingName = shoppingName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
