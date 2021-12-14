package cn.edu.zjut.service;

import cn.edu.zjut.dao.EnterpriseAgencyImpl;
import cn.edu.zjut.dao.EnterpriseDepartmentImpl;
import cn.edu.zjut.dao.ShopManagerImpl;
import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.ShopManager;

import java.util.List;

public class RegisterShopmanagerAndEnterpriseagencyService {
    ShopManagerImpl shopManagerimpl;
    EnterpriseAgencyImpl enterpriseAgencyimpl;
    EnterpriseDepartmentImpl enterpriseDepartmentimpl;
    public void registerShopmanager(ShopManager shopManager) {
        shopManagerimpl.addShopManager(shopManager);
    }

    public void registerEnterpriseagency(EnterpriseAgency enterpriseAgency) {
        enterpriseAgencyimpl.addEnterpriseAgency(enterpriseAgency);
    }

    public List<ShopManager> displayShopmanager(){
        System.out.println("execute --displayShopmanager()-- method.");
        return shopManagerimpl.getAllShopManager();
    }

    public List<EnterpriseAgency> displayenterpriseagency(){
        System.out.println("execute --displayenterpriseAgencr()-- method.");
        return enterpriseAgencyimpl.getAllEnterpriseAgency();
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

    public List<EnterpriseDepartment> queryEnterpriseStructure(int id) {
        return enterpriseDepartmentimpl.getEnterpriseDepartmentById(id);
    }

    public EnterpriseDepartmentImpl getEnterpriseDepartmentimpl() {
        return enterpriseDepartmentimpl;
    }

    public void setEnterpriseDepartmentimpl(EnterpriseDepartmentImpl enterpriseDepartmentimpl) {
        this.enterpriseDepartmentimpl = enterpriseDepartmentimpl;
    }
}

