package cn.edu.zjut.action;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.ElectronicContractsService;

import java.util.List;
import java.util.Map;

public class ElectronicContractsAction {
    private ElectronicContractsService electronicContractsService;
    private ElectronicContracts electronicContracts;
    private EnterpriseDepartment enterpriseDepartment;
    private Enterprise enterprise;
    private EnterpriseAgency enterpriseAgency;
    private Shop shop;
    private ShopManager shopManager;
    private Goods goods;
    private List goodsList;
    private List enterpriseDapartmenList;
    private List electronicContractsList;
    private Map<String, Object> session;
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    //商家查看合同内容
    public String queryElectronicContracts() {
        electronicContractsList =  electronicContractsService.queryElectronicContracts();
        return "success";
    }
//    public String editEnterpriseDepartment() {
//        electronicContracts = enterpriseUserService.editEnterpriseDepartment(enterpriseDepartment.getEnterpriseId());
//        return "success";
//    }

    public void setEnterpriseDepartment(EnterpriseDepartment enterpriseDepartment) {
        this.enterpriseDepartment = enterpriseDepartment;
    }

    public EnterpriseDepartment getEnterpriseDepartment() {
        return enterpriseDepartment;
    }

    public void setEnterpriseDapartmenList(List enterpriseDapartmenList) {
        this.enterpriseDapartmenList = enterpriseDapartmenList;
    }

    public List getEnterpriseDapartmenList() {
        return enterpriseDapartmenList;
    }

    public void setEnterpriseAgency(EnterpriseAgency enterpriseAgency) {
        this.enterpriseAgency = enterpriseAgency;
    }

    public EnterpriseAgency getEnterpriseAgency() {
        return enterpriseAgency;
    }

    public ShopManager getShopManager() {
        return shopManager;
    }

    public void setShopManager(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    public ElectronicContracts getElectronicContracts() {
        return electronicContracts;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }


    public void setElectronicContracts(ElectronicContracts electronicContracts) {
        this.electronicContracts = electronicContracts;
    }

    public Goods getGoods() {
        return goods;
    }

    public List getGoodsList() {
        return goodsList;
    }

    public Shop getShop() {
        return shop;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public void setGoodsList(List goodsList) {
        this.goodsList = goodsList;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setElectronicContractsService(ElectronicContractsService electronicContractsService) {
        this.electronicContractsService = electronicContractsService;
    }

    public ElectronicContractsService getElectronicContractsService() {
        return electronicContractsService;
    }

    public List getElectronicContractsList() {
        return electronicContractsList;
    }

    public void setElectronicContractsList(List electronicContractsList) {
        this.electronicContractsList = electronicContractsList;
    }

}


