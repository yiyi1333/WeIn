package cn.edu.zjut.po;

import java.io.Serializable;
import java.util.List;

public class safeGuardingRights implements Serializable {
    private Integer safeGuardingRightsId;
    private Integer orderId;
    private Integer goodId;
    private String safeGuardingRightsDetails;
    private String safeGuardingRightsImage;
    private String safeGuardingRightsType;
    private Integer safeGuardingRightsNum;
    private String safeGuardingRightsProgress;
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

    public Integer getSafeGuardingRightsId() {
        return safeGuardingRightsId;
    }

    public void setSafeGuardingRightsId(Integer safeGuardingRightsId) {
        this.safeGuardingRightsId = safeGuardingRightsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getSafeGuardingRightsDetails() {
        return safeGuardingRightsDetails;
    }

    public void setSafeGuardingRightsDetails(String safeGuardingRightsDetails) {
        this.safeGuardingRightsDetails = safeGuardingRightsDetails;
    }

    public String getSafeGuardingRightsImage() {
        return safeGuardingRightsImage;
    }

    public void setSafeGuardingRightsImage(String safeGuardingRightsImage) {
        this.safeGuardingRightsImage = safeGuardingRightsImage;
    }

    public String getSafeGuardingRightsType() {
        return safeGuardingRightsType;
    }

    public void setSafeGuardingRightsType(String safeGuardingRightsType) {
        this.safeGuardingRightsType = safeGuardingRightsType;
    }

    public Integer getSafeGuardingRightsNum() {
        return safeGuardingRightsNum;
    }

    public void setSafeGuardingRightsNum(Integer safeGuardingRightsNum) {
        this.safeGuardingRightsNum = safeGuardingRightsNum;
    }

    public String getSafeGuardingRightsProgress() {
        return safeGuardingRightsProgress;
    }

    public void setSafeGuardingRightsProgress(String safeGuardingRightsProgress) {
        this.safeGuardingRightsProgress = safeGuardingRightsProgress;
    }
}
