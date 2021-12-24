package cn.edu.zjut.po;

import java.io.Serializable;
import java.util.List;

public class safeGuardingRights implements Serializable {
    private int safeGuardingRightsId;
    private int orderId;
    private int goodId;
    private String safeGuardingRightsDetails;
    private String safeGuardingRightsImage;
    private String safeGuardingRightsProgress;
    private String safeGuardingRightsType;
    private int safeGuardingRightsNum;
    private OrderGood orderGood;
    private Goods goods;
    private List<safeGuardingRightsProgress> safeGuardingRightsProgresslist;
    private Orders orders;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<cn.edu.zjut.po.safeGuardingRightsProgress> getSafeGuardingRightsProgresslist() {
        return safeGuardingRightsProgresslist;
    }

    public String getSafeGuardingRightsProgress() {
        return safeGuardingRightsProgress;
    }

    public void setSafeGuardingRightsProgress(String safeGuardingRightsProgress) {
        this.safeGuardingRightsProgress = safeGuardingRightsProgress;
    }

    public void setSafeGuardingRightsProgresslist(List<cn.edu.zjut.po.safeGuardingRightsProgress> safeGuardingRightsProgresslist) {
        this.safeGuardingRightsProgresslist = safeGuardingRightsProgresslist;
    }

    public OrderGood getOrderGood() {
        return orderGood;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrderGood(OrderGood orderGood) {
        this.orderGood = orderGood;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getGoodId() {
        return goodId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSafeGuardingRightsId() {
        return safeGuardingRightsId;
    }

    public int getSafeGuardingRightsNum() {
        return safeGuardingRightsNum;
    }

    public String getSafeGuardingRightsDetails() {
        return safeGuardingRightsDetails;
    }

    public String getSafeGuardingRightsImage() {
        return safeGuardingRightsImage;
    }

    public String getSafeGuardingRightsType() {
        return safeGuardingRightsType;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setSafeGuardingRightsDetails(String safeGuardingRightsDetails) {
        this.safeGuardingRightsDetails = safeGuardingRightsDetails;
    }

    public void setSafeGuardingRightsId(int safeGuardingRightsId) {
        this.safeGuardingRightsId = safeGuardingRightsId;
    }

    public void setSafeGuardingRightsImage(String safeGuardingRightsImage) {
        this.safeGuardingRightsImage = safeGuardingRightsImage;
    }


    public void setSafeGuardingRightsNum(int safeGuardingRightsNum) {
        this.safeGuardingRightsNum = safeGuardingRightsNum;
    }

    public void setSafeGuardingRightsType(String safeGuardingRightsType) {
        this.safeGuardingRightsType = safeGuardingRightsType;
    }
}
