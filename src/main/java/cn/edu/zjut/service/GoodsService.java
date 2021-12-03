package cn.edu.zjut.service;

import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.dao.GoodsImpl;
import cn.edu.zjut.po.Goods;

import java.util.List;

public class GoodsService {
    private GoodsMapper goodsDao;
    private GoodsImpl goodsImpl;
    public GoodsMapper getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsMapper goodsDao) {
        this.goodsDao = goodsDao;
    }

    public List searchGoodsByTagsAndName(String keyword){
        List goodlist = goodsDao.searchGoodsByKeyWord(keyword);
        return goodlist;


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
