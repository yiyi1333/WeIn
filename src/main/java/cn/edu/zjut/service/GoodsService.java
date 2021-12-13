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
    public Goods getGoodById(Integer goodid){
        return goodsDao.getGoodById(goodid);
    }

    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    public Goods getGoodsById(int goodsId) {
        List<Goods> goodsList = goodsDao.getAllGoods();
        for (Goods goods : goodsList) {
            if (goods.getGoodsId() == goodsId) {
                return goods;
            }
        }
        return null;
    }

    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

}
