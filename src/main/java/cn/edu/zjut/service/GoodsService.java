package cn.edu.zjut.service;

import cn.edu.zjut.dao.GoodsImpl;
import cn.edu.zjut.po.Goods;

import java.util.List;

public class GoodsService {
    private GoodsImpl goodsImpl;

    public GoodsImpl getGoodsImpl() {
        return goodsImpl;
    }

    public void setGoodsImpl(GoodsImpl goodsImpl) {
        this.goodsImpl = goodsImpl;
    }

    public List<Goods> getAllGoods() {
        System.out.println("execute --getAllGoods()-- method.");
        return goodsImpl.getAllGoods();
    }
}
