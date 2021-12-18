package cn.edu.zjut.po;

import java.sql.Date;
import java.sql.Time;

public class Order {
    private int orderId;
    private String orderStatus; //订单状态
    private String orderPaymentMethod; //支付方式
    private Date orderDate;//下单日期
    private Time orderTime; //下单时间
    private String consumerId; //用户号
    private int shopId; //店铺编号
    private String logisticsSingle; //物流单号
    private int goodsId; //商品号
    private int goodsnumber; //数量
    private String deliveredDetailedAddress; //收货地址详细地址
    private String deliveredName; //收货人姓名
    private String deliveredPhone; //收货人手机号
    private String deliverProvince;//收货省份
    private String  deliverCity;//收货地址市
    private String deliverArea;//收货地址区
    private String deliverStreet;//收货地址街道
    private String  warehouseProvince;//发货省
    private String warehouseCity;//发货市
    private String warehouseArea;//发货地址区
    private String  warehouseName; //发货人姓名
    private String warehousePhone; //发货人手机号
    private String warehouseDetailedAddress; //发货仓库详细地址
    private double actualAmountPaid;   //实际支付金额
    private double goodTotalPrices;  //商品总价
    private double discountAmount;   //优惠金额

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
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

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(int goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    public String getDeliveredDetailedAddress() {
        return deliveredDetailedAddress;
    }

    public void setDeliveredDetailedAddress(String deliveredDetailedAddress) {
        this.deliveredDetailedAddress = deliveredDetailedAddress;
    }

    public String getDeliveredName() {
        return deliveredName;
    }

    public void setDeliveredName(String deliveredName) {
        this.deliveredName = deliveredName;
    }

    public String getDeliveredPhone() {
        return deliveredPhone;
    }

    public void setDeliveredPhone(String deliveredPhone) {
        this.deliveredPhone = deliveredPhone;
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

    public String getDeliverStreet() {
        return deliverStreet;
    }

    public void setDeliverStreet(String deliverStreet) {
        this.deliverStreet = deliverStreet;
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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    public String getWarehouseDetailedAddress() {
        return warehouseDetailedAddress;
    }

    public void setWarehouseDetailedAddress(String warehouseDetailedAddress) {
        this.warehouseDetailedAddress = warehouseDetailedAddress;
    }

    public double getActualAmountPaid() {
        return actualAmountPaid;
    }

    public void setActualAmountPaid(double actualAmountPaid) {
        this.actualAmountPaid = actualAmountPaid;
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
}
