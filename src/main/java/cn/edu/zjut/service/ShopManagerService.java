package cn.edu.zjut.service;

import cn.edu.zjut.dao.ShopManagerImpl;
import cn.edu.zjut.po.ShopManager;

import java.util.Objects;

public class ShopManagerService {
    private ShopManagerImpl shopManagerImpl;

    public ShopManagerImpl getShopManagerImpl() {
        return shopManagerImpl;
    }

    public void setShopManagerImpl(ShopManagerImpl shopManagerImpl) {
        this.shopManagerImpl = shopManagerImpl;
    }

    public ShopManager login(ShopManager shopManager) {
        System.out.println("execute --login()-- method.");

        ShopManager managerList = shopManagerImpl.getShopManagerByAccount(shopManager.getShopManagerAccount());
        if (Objects.equals(shopManager.getShopManagerPassword(), managerList.getShopManagerPassword())) {
            return managerList;
        }

        return null;
    }
}
