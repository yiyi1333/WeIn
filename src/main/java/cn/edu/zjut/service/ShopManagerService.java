package cn.edu.zjut.service;

import cn.edu.zjut.dao.ShopManagerImpl;
import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.ShopManager;

import java.util.List;

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

        List<ShopManager> managerList = shopManagerImpl.getAllShopManager();
        for (ShopManager manager : managerList) {
            if (manager.getShopManagerAccount().equals(shopManager.getShopManagerAccount()) && manager.getShopManagerPassword().equals(shopManager.getShopManagerPassword())) {
                return manager;
            }
        }
        return null;
    }
}
