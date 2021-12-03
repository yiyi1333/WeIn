package cn.edu.zjut.action;

import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.po.User;
import cn.edu.zjut.service.GoodsService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsAction implements SessionAware {
    private Map<String, Object> session;
    private GoodsService goodsService;
    private String keyword;
    private List goodslist;
    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
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

    public String displayShopGoods() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopGoodsFailed";
        }
        List<Goods> ans = goodsService.getAllGoods();
        List<Goods> goodsList = new ArrayList<>();
        for (Goods goods : ans) {
            if (goods.getShopId() == shopManager.getShopId()) {
                goodsList.add(goods);
            }
        }
        session.put("goodsList", goodsList);
        return "displayShopGoodsSuccess";
    }
}
