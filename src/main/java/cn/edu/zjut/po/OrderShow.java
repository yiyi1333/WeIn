package cn.edu.zjut.po;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class OrderShow {
    int orderId;    //订单号
    double actuaLAmountPaid;    //订单实际支付总价
    String orderStatus; //订单状态
    String orderPaymentMethod;  //支付方式
    String consumerId;  //用户id
    Time orderTime; //下单时间
    int shopId; //店铺id
    String logisticsSingle; //物流单号
    double goodTotalPrices; //商品总价
    double discountAmount;  //折扣价格
    String warehousePhone;  //发货人联系方式
    String deliveredPhone;  //收货人联系方式
    String warehouseDetailedAddress;    //发货仓库具体地址
    String deliverProvince; // 收货人省份
    String deliverCity; // 收货人城市
    String deliverArea;// 收货人地区
    String deliveredName;   // 收货人名称
    String deliveredDetailedAddress;//收货人具体地址
    String warehouseName;   //发货人名称
    String warehouseProvince;   //发货人省份
    String warehouseCity;   //发货人城市
    String warehouseArea;   //发货人地区
    Date orderDate; //下单日期
    List<CartGoods> goodsList;// 订单中的商品信息

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getActuaLAmountPaid() {
        return actuaLAmountPaid;
    }

    public void setActuaLAmountPaid(double actuaLAmountPaid) {
        this.actuaLAmountPaid = actuaLAmountPaid;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public void setOrderPaymentMethod(String orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getLogisticsSingle() {
        return logisticsSingle;
    }

    public void setLogisticsSingle(String logisticsSingle) {
        this.logisticsSingle = logisticsSingle;
    }

    public double getGoodTotalPrices() {
        return goodTotalPrices;
    }

    public void setGoodTotalPrices(double goodTotalPrices) {
        this.goodTotalPrices = goodTotalPrices;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    public String getDeliveredPhone() {
        return deliveredPhone;
    }

    public void setDeliveredPhone(String deliveredPhone) {
        this.deliveredPhone = deliveredPhone;
    }

    public String getWarehouseDetailedAddress() {
        return warehouseDetailedAddress;
    }

    public void setWarehouseDetailedAddress(String warehouseDetailedAddress) {
        this.warehouseDetailedAddress = warehouseDetailedAddress;
    }

    public String getDeliverProvince() {
        return deliverProvince;
    }

    public void setDeliverProvince(String deliverProvince) {
        this.deliverProvince = deliverProvince;
    }

    public String getDeliverCity() {
        return deliverCity;
    }

    public void setDeliverCity(String deliverCity) {
        this.deliverCity = deliverCity;
    }

    public String getDeliverArea() {
        return deliverArea;
    }

    public void setDeliverArea(String deliverArea) {
        this.deliverArea = deliverArea;
    }

    public String getDeliveredName() {
        return deliveredName;
    }

    public void setDeliveredName(String deliveredName) {
        this.deliveredName = deliveredName;
    }

    public String getDeliveredDetailedAddress() {
        return deliveredDetailedAddress;
    }

    public void setDeliveredDetailedAddress(String deliveredDetailedAddress) {
        this.deliveredDetailedAddress = deliveredDetailedAddress;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseProvince() {
        return warehouseProvince;
    }

    public void setWarehouseProvince(String warehouseProvince) {
        this.warehouseProvince = warehouseProvince;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public String getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(String warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<CartGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<CartGoods> goodsList) {
        this.goodsList = goodsList;
    }
}
