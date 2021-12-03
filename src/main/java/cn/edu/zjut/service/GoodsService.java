package cn.edu.zjut.service;

import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.dao.GoodsImpl;
import cn.edu.zjut.po.Goods;

import java.util.List;

public class GoodsService {
    private GoodsMapper goodsDao;

    public GoodsMapper getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsMapper goodsDao) {
        this.goodsDao = goodsDao;
    }

    public List searchGoodsByTagsAndName(String keyword) {
        List goodlist = goodsDao.searchGoodsByKeyWord(keyword);
        return goodlist;
    }

    public List<Goods> getAllGoods() {
        System.out.println("execute --getAllGoods()-- method.");
        return goodsDao.getAllGoods();
    }

    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    public Goods getGoodsById(int goodsId) {
        return goodsDao.getGoodsById(goodsId);
    }
}
