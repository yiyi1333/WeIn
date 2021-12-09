package cn.edu.zjut.po;

import java.io.Serializable;

public class CartGoods implements Serializable {
    private Goods goods;
    private int goodsNum;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }
}
