package cn.edu.zjut.action;

import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.po.User;
import cn.edu.zjut.po.WareHouseAddress;
import cn.edu.zjut.service.GoodsService;
import cn.edu.zjut.service.WareHouseAddressService;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.RequestDispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsAction implements SessionAware{
    private Map<String, Object> session;
    private GoodsService goodsService;
    private String keyword;
    private List goodslist;
    private String goodsId;
    private Goods good;
    private WareHouseAddressService wareHouseAddressService;
    private List wareHouseAddresslist;

    private Goods goods;

    public List getWareHouseAddresslist() {
        return wareHouseAddresslist;
    }

    public void setWareHouseAddresslist(List wareHouseAddresslist) {
        this.wareHouseAddresslist = wareHouseAddresslist;
    }

    public void setWareHouseAddressService(WareHouseAddressService wareHouseAddressService) {
        this.wareHouseAddressService = wareHouseAddressService;
    }

    public WareHouseAddressService getWareHouseAddressService() {
        return wareHouseAddressService;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goods getGoods() {
        return goods;
    }

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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public String search(){
        System.out.println(keyword);
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
            if (goods.getShopId()== shopManager.getShopId()) {
                goodsList.add(goods);
            }
        }
        session.put("goodsList", goodsList);
        return "displayShopGoodsSuccess";
    }

    public String displayGoodsDetail(){
        //将String类型的GoodsId转换为Int;
        int goodid = Integer.parseInt(goodsId);
        good = goodsService.getGoodById(goodid);
        return "success";
    }

    public String updateGoods() {
        if("".equals(goods.getGoodsDetails())) {
            goods.setGoodsDetails(null);
        }
        goodsService.updateGoods(goods);
        goods = goodsService.getGoodsById(goods.getGoodsId());
        session.put("goods", goods);
        return "success";
    }

    public String getGoodsById() {
        goods = goodsService.getGoodsById(goods.getGoodsId());
        session.put("goods", goods);
        return "success";
    }

    public String addGoods(){
        if("".equals(goods.getGoodsDetails())) {
            goods.setGoodsDetails(null);
        }
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        goods.setShopId(shopManager.getShopId());
        goodsService.addGoods(goods);
        return "addSuccess";
    }

    public String selectGoods(){
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopGoodsFailed";
        }
        String name ="%";
        name+=goods.getGoodsName();
        name+="%";
        goods.setGoodsName(name);
        String tag ="%";
        tag+=goods.getTags();
        tag+="%";
        goods.setTags(tag);
        List<Goods> ans = goodsService.selectGoods(goods);
        List<Goods> goodsList = new ArrayList<>();
        for (Goods goods : ans) {
            if (goods.getShopId()== shopManager.getShopId()) {
                goodsList.add(goods);
            }
        }
        session.put("goodsList", goodsList);
        return "displayShopGoodsSuccess";
    }

    public String deleteGoods(){
        goodsService.deleteGoods(goods.getGoodsId());
        List<Goods> ans = (List<Goods>) session.get("goodsList");
        List<Goods> goodsList = new ArrayList<>();
        for (Goods good : ans) {
            if (good.getGoodsId() != goods.getGoodsId()) {
                goodsList.add(good);
            }
        }
        session.put("goodsList", goodsList);
        return "success";
    }

    public String displayShopWareHouseAddress() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopWareHouseAddressFailed";
        }
        List<WareHouseAddress> ans = wareHouseAddressService.getAllWareHouseAddress();
        List<WareHouseAddress> wareHouseAddressList = new ArrayList<>();
        for (WareHouseAddress wareHouseAddress : ans) {
            if (wareHouseAddress.getShopId() == shopManager.getShopId()) {
                wareHouseAddressList.add(wareHouseAddress);
            }
        }
        session.put("wareHouseAddressList", wareHouseAddressList);
        return "displayShopWareHouseAddressSuccess";
    }
}
