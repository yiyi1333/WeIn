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
    private int shopId;
    private Shop shop;
    private int isGrouding;
    private int warehouseId;
    private double goodsWeight;


    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsRealPrice=" + goodsRealPrice +
                ", goodsDetails='" + goodsDetails + '\'' +
                ", goodsStock=" + goodsStock +
                ", tags='" + tags + '\'' +
                ", goodsImage='" + goodsImage + '\'' +
                ", shopId=" + shopId +
                ", shop=" + shop +
                ", isGrouding=" + isGrouding +
                ", warehouseId=" + warehouseId +
                ", goodsWeight=" + goodsWeight +
                '}';
    }

    public double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public double getGoodsRealPrice() {
        return goodsRealPrice;
    }

    public void setGoodsRealPrice(double goodsRealPrice) {
        this.goodsRealPrice = goodsRealPrice;
    }

    public Goods() {
    }

    public Goods(int goodsId, String goodsName, double goodsPrice, String goodsDetails, int goodsStock, String tags, String goodsImage, int shopId, Shop shop, int isGrouding, int warehouseId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDetails = goodsDetails;
        this.goodsStock = goodsStock;
        this.tags = tags;
        this.goodsImage = goodsImage;
        this.shopId = shopId;
        this.shop = shop;
        this.isGrouding = isGrouding;
        this.warehouseId = warehouseId;
    }

    public int getIsGrouding() { return isGrouding; }

    public void setIsGrouding(int isGrouding) { this.isGrouding = isGrouding; }

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
