package cn.edu.zjut.po;

public class Goods {
    private int goodsId;
    private String goodsName;
    private double goodprice;
    private String goodsDetails;
    private int goodsStock;
    private int shopId;
    private String tags;
    private String goodsImage;

    public Goods() {
    }

    public int getShopId() {
        return shopId;
    }

    public double getGoodprice() {
        return goodprice;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getTags() {
        return tags;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setGoodprice(double goodprice) {
        this.goodprice = goodprice;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
