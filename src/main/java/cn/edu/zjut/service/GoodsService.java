package cn.edu.zjut.service;

import cn.edu.zjut.dao.GoodsMapper;

import java.util.List;

public class GoodsService {
    private GoodsMapper goodsDao;

    public GoodsMapper getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsMapper goodsDao) {
        this.goodsDao = goodsDao;
    }

    public List searchGoodsByTagsAndName(String keyword){
        List goodlist = goodsDao.searchGoodsByKeyWord(keyword);
        return goodlist;
    }
}
