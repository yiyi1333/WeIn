package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.service.RegisterShopmanagerAndEnterpriseagencyService;

public class registerShopmanagerAndEnterpriseagencyAction {
    private RegisterShopmanagerAndEnterpriseagencyService registerShopmanagerAndEnterpriseagencyService = null;
    private ShopManager shopManager;
    private EnterpriseAgency enterpriseAgency;

    public EnterpriseAgency getEnterpriseAgency() {
        return enterpriseAgency;
    }

    public void setEnterpriseAgency(EnterpriseAgency enterpriseAgency) {
        this.enterpriseAgency = enterpriseAgency;
    }

    public void setRegisterShopmanagerAndEnterpriseagencyService(RegisterShopmanagerAndEnterpriseagencyService registerShopmanagerAndEnterpriseagencyService) {
        this.registerShopmanagerAndEnterpriseagencyService = registerShopmanagerAndEnterpriseagencyService;
    }

    public void setShopManager(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    public RegisterShopmanagerAndEnterpriseagencyService getRegisterShopmanagerAndEnterpriseagencyService() {
        return registerShopmanagerAndEnterpriseagencyService;
    }

    public ShopManager getShopManager() {
        return shopManager;
    }

    public String registerShopmanager() {
        registerShopmanagerAndEnterpriseagencyService.registerShopmanager(shopManager);
        return "success";
    }

    public String registerEnterpriseagency( ) {
        registerShopmanagerAndEnterpriseagencyService.registerEnterpriseagency(enterpriseAgency);
        return "success";
    }

    public void setRegisterShopmanagerAndEnterpriseagencyService() {
    }

}
