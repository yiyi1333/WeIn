package cn.edu.zjut.po;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private Shop shop;
    private List<CartGoods> goodsList;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List goodsList) {
        this.goodsList = goodsList;
    }
}
