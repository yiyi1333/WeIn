package cn.edu.zjut.po;

public class ShopManager {
    private int shopId;
    private int shopManagerId;
    private String shopManagerAccount;
    private String shopManagerPassword;
    private String shopManagerName;
    private String idCardNumber;

    public ShopManager(){}

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setShopManagerAccount(String shopManagerAccount) {
        this.shopManagerAccount = shopManagerAccount;
    }

    public void setShopManagerId(int shopManagerId) {
        this.shopManagerId = shopManagerId;
    }

    public void setShopManagerName(String shopManagerName) {
        this.shopManagerName = shopManagerName;
    }

    public void setShopManagerPassword(String shopManagerPassword) {
        this.shopManagerPassword = shopManagerPassword;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public int getShopId() {
        return shopId;
    }

    public int getShopManagerId() {
        return shopManagerId;
    }

    public String getShopManagerAccount() {
        return shopManagerAccount;
    }

    public String getShopManagerName() {
        return shopManagerName;
    }

    public String getShopManagerPassword() {
        return shopManagerPassword;
    }
}
