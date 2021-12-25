package cn.edu.zjut.action;


import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.po.WareHouseAddress;
import cn.edu.zjut.service.GoodsService;
import cn.edu.zjut.service.WareHouseAddressService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WareHouseAddressAction implements SessionAware {
    private Map<String, Object> session;
    private WareHouseAddressService wareHouseAddressService;
    private List wareHouseAddresslist;
    private WareHouseAddress wareHouseAddress;
    private Integer warehouseId;
    private String tag;//批量删除ID号集合
    private GoodsService goodsService;

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public WareHouseAddress getWareHouseAddress() {
        return wareHouseAddress;
    }

    public void setWareHouseAddress(WareHouseAddress wareHouseAddress) {
        this.wareHouseAddress = wareHouseAddress;
    }

    public List getWareHouseAddresslist() {
        return wareHouseAddresslist;
    }

    public WareHouseAddressService getWareHouseAddressService() {
        return wareHouseAddressService;
    }

    public void setWareHouseAddresslist(List wareHouseAddresslist) {
        this.wareHouseAddresslist = wareHouseAddresslist;
    }

    public void setWareHouseAddressService(WareHouseAddressService wareHouseAddressService) {
        this.wareHouseAddressService = wareHouseAddressService;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }


    public String displayShopWareHouseAddress() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopWareHouseAddressFailed";
        }
        List<WareHouseAddress> ans = wareHouseAddressService.getAllWareHouseAddress();
        List<WareHouseAddress> wareHouseAddressList = new ArrayList<>();
        System.out.println(ans.size());
        for (WareHouseAddress wareHouseAddress : ans) {
            if (wareHouseAddress.getShopId() == shopManager.getShopId()) {
                wareHouseAddressList.add(wareHouseAddress);
            }
        }
        System.out.println(wareHouseAddressList.size());
        session.put("wareHouseAddressList", wareHouseAddressList);
        return "displayShopWareHouseAddressSuccess";
    }

    public String addWareHouseAddress() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        wareHouseAddress.setShopId(shopManager.getShopId());
        wareHouseAddressService.addWareHouseAddress(wareHouseAddress);
        return "success";
    }

    public String selectWareHouseAddress() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        wareHouseAddress.setShopId(shopManager.getShopId());
        System.out.println(wareHouseAddress.getProvince());
        List<WareHouseAddress> wareHouseAddressList = wareHouseAddressService.selectWareHouseAddress(wareHouseAddress);
        session.put("wareHouseAddressList", wareHouseAddressList);
        return "success";
    }

    public String updateWareHouseAddress() {
        WareHouseAddress obj = (WareHouseAddress) session.get("wareHouseAddress");
        wareHouseAddress.setWarehouseId(obj.getWarehouseId());
        wareHouseAddressService.updateWareHouseAddress(wareHouseAddress);
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        List<WareHouseAddress> list = wareHouseAddressService.getAllWareHouseAddress();
        List<WareHouseAddress> wareHouseAddressList = new ArrayList<>();
        System.out.println(list.size());
        for (WareHouseAddress wareHouseAddress : list) {
            if (wareHouseAddress.getShopId() == shopManager.getShopId()) {
                wareHouseAddressList.add(wareHouseAddress);
            }
        }
        System.out.println(wareHouseAddressList.size());
        session.put("wareHouseAddressList", wareHouseAddressList);
        return "success";
    }

    public String deleteWareHouseAddress() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        wareHouseAddressService.deleteWareHouseAddressById(warehouseId);
        List<WareHouseAddress> list = wareHouseAddressService.getAllWareHouseAddress();
        List<WareHouseAddress> wareHouseAddressList = new ArrayList<>();
        System.out.println(list.size());
        for (WareHouseAddress wareHouseAddress : list) {
            if (wareHouseAddress.getShopId() == shopManager.getShopId()) {
                wareHouseAddressList.add(wareHouseAddress);
            }
        }
        System.out.println(wareHouseAddressList.size());
        session.put("wareHouseAddressList", wareHouseAddressList);
        return "success";
    }

    public String selectWareHouseAddressById() {
        WareHouseAddress obj = wareHouseAddressService.selectWareHouseAddressById(warehouseId);
        session.put("wareHouseAddress", obj);
        return "success";
    }

    public String deleteWareHouseAddressByIds() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                wareHouseAddressService.deleteWareHouseAddressById(Integer.parseInt(strs[i]));
            } catch (Exception e) {
            }
        }
        List<WareHouseAddress> list = wareHouseAddressService.getAllWareHouseAddress();
        List<WareHouseAddress> wareHouseAddressList = new ArrayList<>();
        System.out.println(list.size());
        for (WareHouseAddress wareHouseAddress : list) {
            if (wareHouseAddress.getShopId() == shopManager.getShopId()) {
                wareHouseAddressList.add(wareHouseAddress);
            }
        }
        System.out.println(wareHouseAddressList.size());
        session.put("wareHouseAddressList", wareHouseAddressList);
        return "success";
    }

    public String selectGoodsByWareHouseAddressId() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopGoodsFailed";
        }
        List<Goods> ans = goodsService.selectGoodsByWarehouseId(warehouseId);
        List<Goods> goodsList = new ArrayList<>();
        for (Goods goods : ans) {
            if (goods.getShopId() == shopManager.getShopId()) {
                goodsList.add(goods);
            }
        }
        session.put("goodsList", goodsList);
        return "success";
    }

}
