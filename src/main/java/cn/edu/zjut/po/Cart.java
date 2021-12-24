package cn.edu.zjut.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private Shop shop;
    private ArrayList<CartGoods> goodsList;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ArrayList<CartGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(ArrayList<CartGoods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "shop=" + shop +
                ", goodsList=" + goodsList +
                '}';
    }
}
