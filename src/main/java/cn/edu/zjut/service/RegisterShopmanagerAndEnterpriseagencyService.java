package cn.edu.zjut.service;

import cn.edu.zjut.dao.EnterpriseAgencyImpl;
import cn.edu.zjut.dao.ShopManagerImpl;
import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.ShopManager;

public class RegisterShopmanagerAndEnterpriseagencyService {
    ShopManagerImpl shopManagerimpl;
    EnterpriseAgencyImpl enterpriseAgencyimpl;
    public void registerShopmanager(ShopManager shopManager) {
        shopManagerimpl.addShopManager(shopManager);
    }

    public void registerEnterpriseagency(EnterpriseAgency enterpriseAgency) {
        enterpriseAgencyimpl.addEnterpriseAgency(enterpriseAgency);
    }

    public EnterpriseAgencyImpl getEnterpriseAgencyimpl() {
        return enterpriseAgencyimpl;
    }

    public ShopManagerImpl getShopManagerimpl() {
        return shopManagerimpl;
    }

    public void setShopManagerimpl(ShopManagerImpl shopManagerimpl) {
        this.shopManagerimpl = shopManagerimpl;
    }

    public void setEnterpriseAgencyimpl(EnterpriseAgencyImpl enterpriseAgencyimpl) {
        this.enterpriseAgencyimpl = enterpriseAgencyimpl;
    }
}

