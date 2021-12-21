package cn.edu.zjut.po;

import java.sql.Time;
import java.util.Date;

/**
 * @author hydrogen_zyx
 */
public class Orders {
    int orderId;    //
    double actuaLAmountPaid;    //
    String orderStatus; //
    String orderPaymentMethod;  //
    String consumerId;  //
    Time orderTime; //
    int shopId; //
    String logisticsSingle; //
    double goodTotalPrices; //
    double discountAmount;  //
    String warehousePhone;  //
    String deliveredPhone;  //
    String warehouseDetailedAddress;    //
    String deliverProvince; //
    String deliverCity; //
    String deliverArea;
    String deliveredName;   //
    String deliveredDetailedAddress;
    String warehouseName;   //
    String warehouseProvince;   //
    String warehouseCity;   //
    String warehouseArea;   //
    Date orderDate; //

    public Orders(){}

    public Date getOrderDate() {
        return orderDate;
    }

    public double getActuaLAmountPaid() {
        return actuaLAmountPaid;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getGoodTotalPrices() {
        return goodTotalPrices;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getShopId() {
        return shopId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public String getDeliverArea() {
        return deliverArea;
    }

    public String getDeliverCity() {
        return deliverCity;
    }

    public String getDeliveredDetailedAddress() {
        return deliveredDetailedAddress;
    }

    public String getDeliveredName() {
        return deliveredName;
    }

    public String getDeliveredPhone() {
        return deliveredPhone;
    }

    public String getDeliverProvince() {
        return deliverProvince;
    }

    public String getLogisticsSingle() {
        return logisticsSingle;
    }

    public String getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getWarehouseArea() {
        return warehouseArea;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public String getWarehouseDetailedAddress() {
        return warehouseDetailedAddress;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public String getWarehouseProvince() {
        return warehouseProvince;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setActuaLAmountPaid(double actuaLAmountPaid) {
        this.actuaLAmountPaid = actuaLAmountPaid;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public void setDeliverArea(String deliverArea) {
        this.deliverArea = deliverArea;
    }

    public void setDeliverCity(String deliverCity) {
        this.deliverCity = deliverCity;
    }

    public void setDeliveredDetailedAddress(String deliveredDetailedAddress) {
        this.deliveredDetailedAddress = deliveredDetailedAddress;
    }

    public void setDeliveredName(String deliveredName) {
        this.deliveredName = deliveredName;
    }

    public void setDeliveredPhone(String deliveredPhone) {
        this.deliveredPhone = deliveredPhone;
    }

    public void setDeliverProvince(String deliverProvince) {
        this.deliverProvince = deliverProvince;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setGoodTotalPrices(double goodTotalPrices) {
        this.goodTotalPrices = goodTotalPrices;
    }

    public void setLogisticsSingle(String logisticsSingle) {
        this.logisticsSingle = logisticsSingle;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderPaymentMethod(String orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setWarehouseArea(String warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public void setWarehouseDetailedAddress(String warehouseDetailedAddress) {
        this.warehouseDetailedAddress = warehouseDetailedAddress;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    public void setWarehouseProvince(String warehouseProvince) {
        this.warehouseProvince = warehouseProvince;
    }
}
