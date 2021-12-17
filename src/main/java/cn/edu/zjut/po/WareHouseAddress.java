package cn.edu.zjut.po;

import java.io.Serializable;

public class WareHouseAddress implements Serializable {
    private String warehousePhone; //发货人手机号
    private int warehouseId; //发货地址编号
    private String warehouseDetailedAddress; //详细地址
    private String warehouseName;//发货人姓名
    private int shopId;//店铺商家
    private String province;//省份
    private String city;//市
    private String district;//区县

    @Override
    public String toString() {
        return "WareHouseAddress{" +
                "warehouseId=" + warehouseId +
                ", warehouseDetailedAddress='" + warehouseDetailedAddress + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", shopId='" + shopId + '\'' +
                ", warehousePhone='" + warehousePhone + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", city=" + city +
                '}';
    }


    public WareHouseAddress(){

    }

    public WareHouseAddress(String warehouseName,String warehousePhone,String warehouseDetailedAddress,String province,String city,String district,int warehouseId,int shopId)
    {
        this.province=province;
        this.city=city;
        this.district=district;
        this.shopId=shopId;
        this.warehouseName=warehouseName;
        this.warehouseDetailedAddress=warehouseDetailedAddress;
        this.warehouseId=warehouseId;
        this.warehousePhone=warehousePhone;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
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

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
