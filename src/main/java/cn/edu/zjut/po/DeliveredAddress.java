package cn.edu.zjut.po;

public class DeliveredAddress {
    private String deliveredPhone;
    private int deliveredId;
    private int deliveredAreaId;
    private String deliveredDetailedAddress;
    private String deliveredName;

    public DeliveredAddress(){

    }

    public DeliveredAddress(String deliveredDetailedAddress,String deliveredPhone,String deliveredName,int deliveredAreaId,int deliveredId){
        this.deliveredAreaId=deliveredAreaId;
        this.deliveredDetailedAddress=deliveredDetailedAddress;
        this.deliveredPhone=deliveredPhone;
        this.deliveredName=deliveredName;
        this.deliveredId=deliveredId;
    }

    public String getDeliveredPhone() {
        return deliveredPhone;
    }

    public String getDeliveredName() {
        return deliveredName;
    }

    public String getDeliveredDetailedAddress() {
        return deliveredDetailedAddress;
    }

    public int getDeliveredAreaId() {
        return deliveredAreaId;
    }

    public int getDeliveredId() {
        return deliveredId;
    }

    public void setDeliveredPhone(String deliveredPhone) {
        this.deliveredPhone = deliveredPhone;
    }

    public void setDeliveredName(String deliveredName) {
        this.deliveredName = deliveredName;
    }

    public void setDeliveredDetailedAddress(String deliveredDetailedAddress) {
        this.deliveredDetailedAddress = deliveredDetailedAddress;
    }

    public void setDeliveredAreaId(int deliveredAreaId) {
        this.deliveredAreaId = deliveredAreaId;
    }

    public void setDeliveredId(int deliveredId) {
        this.deliveredId = deliveredId;
    }
}
