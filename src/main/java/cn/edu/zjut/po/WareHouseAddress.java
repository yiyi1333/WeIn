package cn.edu.zjut.po;

public class WareHouseAddress {
    private String warehousePhone; //发货人手机号
    private int deliveredAeraId; //区县编号
    private int warehouseId; //发货地址编号
    private String warehouseDetailedAddress; //详细地址
    private String warehouseName;//发货人姓名
    private int shopId;//店铺商家

    public WareHouseAddress(){

    }

    public WareHouseAddress(String warehouseName,String warehousePhone,String warehouseDetailedAddress,int deliveredAeraId,int warehouseId,int shopId)
    {
        this.deliveredAeraId=deliveredAeraId;
        this.shopId=shopId;
        this.warehouseName=warehouseName;
        this.warehouseDetailedAddress=warehouseDetailedAddress;
        this.warehouseId=warehouseId;
        this.warehousePhone=warehousePhone;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public String getWarehouseDetailedAddress() {
        return warehouseDetailedAddress;
    }

    public int getShopId() {
        return shopId;
    }

    public int getDeliveredAeraId() {
        return deliveredAeraId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public void setWarehouseDetailedAddress(String warehouseDetailedAddress) {
        this.warehouseDetailedAddress = warehouseDetailedAddress;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setDeliveredAeraId(int deliveredAeraId) {
        this.deliveredAeraId = deliveredAeraId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }
}
