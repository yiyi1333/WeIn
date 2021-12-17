package cn.edu.zjut.po;

import java.sql.Date;
import java.sql.Time;

public class ElectronicContracts {
    private int electronicContractsId;
    private int enterpriseAgencyId;
    private int enterpriseId;
    private int shopmanagerId;
    private int shopId;
    private Date starttime;
    private Date endtime;
    private int goodsId;
    private int enterpriseDepartmentId;
    private double discount;
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public int getElectronicContractsId() {
        return electronicContractsId;
    }

    public void setElectronicContractsId(int electronicContractsId) {
        this.electronicContractsId = electronicContractsId;
    }

    public double getDiscount() {
        return discount;
    }

    public int getEnterpriseDepartmentId() {
        return enterpriseDepartmentId;
    }


    public int getEnterpriseId() {
        return enterpriseId;
    }

    public int getEnterpriseAgencyId() {
        return enterpriseAgencyId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public int getShopmanagerId() {
        return shopmanagerId;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getShopId() {
        return shopId;
    }

    public Date getEndtime() {
        return endtime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public void setEnterpriseDepartmentId(int enterpriseDepartmentId) {
        this.enterpriseDepartmentId = enterpriseDepartmentId;
    }

    public void setEnterpriseAgencyId(int enterpriseAgencyId) {
        this.enterpriseAgencyId = enterpriseAgencyId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setShopmanagerId(int shopmanagerId) {
        this.shopmanagerId = shopmanagerId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

}

