package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.service.RegisterShopmanagerAndEnterpriseagencyService;

import java.util.ArrayList;
import java.util.List;

public class registerShopmanagerAndEnterpriseagencyAction {
    private RegisterShopmanagerAndEnterpriseagencyService registerShopmanagerAndEnterpriseagencyService = null;
    private ShopManager shopManager;
    private EnterpriseAgency enterpriseAgency;
    private List shopManagerList;
    private List enterpriseagencyList;

    public List getShopManagerList() {
        return shopManagerList;
    }

    public void setShopManagerList(List shopManagerList) {
        this.shopManagerList = shopManagerList;
    }

    public List getEnterpriseagencyList() {
        return enterpriseagencyList;
    }

    public void setEnterpriseagencyList(List enterpriseagencyList) {
        this.enterpriseagencyList = enterpriseagencyList;
    }

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

    public String registerEnterpriseagency() {
        registerShopmanagerAndEnterpriseagencyService.registerEnterpriseagency(enterpriseAgency);
        return "success";
    }

    public String displayShopmanager() {
        shopManagerList = registerShopmanagerAndEnterpriseagencyService.displayShopmanager();
        return "success";
    }

    public String displayenterpriseagency() {
        enterpriseagencyList = registerShopmanagerAndEnterpriseagencyService.displayenterpriseagency();
        return "success";
    }


    public void setRegisterShopmanagerAndEnterpriseagencyService() {
    }


}
