package cn.edu.zjut.action;

import cn.edu.zjut.service.GoodsService;

import java.util.List;

public class GoodsAction {
    private GoodsService goodsService;
    private String keyword;
    private List goodslist;
    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(List goodslist) {
        this.goodslist = goodslist;
    }

    public String search(){
        goodslist = goodsService.searchGoodsByTagsAndName(keyword);
        return "success";
    }
}
