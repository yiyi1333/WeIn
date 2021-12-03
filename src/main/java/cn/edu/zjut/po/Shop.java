package cn.edu.zjut.po;

import java.io.Serializable;

public class Shop implements Serializable {
    private int shopId;
    private String shopName;
    private String shopDescription;
    private Enterprise enterprise;

    public Shop() {
    }

    public Shop(int shopId, String shopName, String shopDescription, Enterprise enterprise) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopDescription = shopDescription;
        this.enterprise = enterprise;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
