package cn.edu.zjut.po;

import java.io.Serializable;

public class Goods implements Serializable {
    private int goodsId;
    private String goodsName;
    private double goodsPrice;
    private double goodsRealPrice;
    private String goodsDetails;
    private int goodsStock;
    private String tags;
    private String goodsImage;
    private double goodsWeight;
    private int shopId;
    private Shop shop;

    public double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public double getGoodsRealPrice() {
        return goodsRealPrice;
    }

    public void setGoodsRealPrice(double goodsRealPrice) {
        this.goodsRealPrice = goodsRealPrice;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getShopId() {
        return shopId;
    }
}
