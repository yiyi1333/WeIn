package cn.edu.zjut.action;


import cn.edu.zjut.po.ShopManager;

import cn.edu.zjut.po.WareHouseAddress;
import cn.edu.zjut.service.WareHouseAddressService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WareHouseAddressAction implements SessionAware {
    private Map<String, Object> session;
    private WareHouseAddressService wareHouseAddressService;
    private List wareHouseAddresslist;

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
}
