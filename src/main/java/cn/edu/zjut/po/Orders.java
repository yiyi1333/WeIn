package cn.edu.zjut.po;

import java.sql.Time;

public class Orders {
    private int orderId;
    private String orderStatus; //订单状态
    private String orderPaymentMethod; //支付方式
    private Time orderTime; //下单时间
    private String consumerId; //用户号
    private int shopId; //店铺编号
    private String logisticsSingle; //物流单号
    private int goodsId; //商品号
    private int goodsnumber; //数量
    private String deliveredDetailedAddress; //收货地址详细地址
    private String deliveredName; //收货人姓名
    private String deliveredPhone; //收货人手机号
    private int deliveredAeraId; //收货仓库区号
    private int warehouseAeraId; //发货地址区号
    private String  warehouseName; //发货人姓名
    private String warehousePhone; //发货人手机号
    private String warehouseDetailedAddress; //发货仓库详细地址
    private double actualAmountPaid;   //实际支付金额
    private double goodTotalPrices;  //商品总价
    private double discountAmount;   //优惠金额

    public Orders(){

    }

    public Orders(int orderId, String orderStatus, String orderPaymentMethod, String consumerId, Time orderTime, int shopId, String logisticsSingle, int goodsId, String warehousePhone, int goodsnumber, String deliveredPhone, int deliveredAeraId, int warehouseAeraId, String warehouseDetailedAddress, String deliveredDetailedAddress, String deliveredName, String warehouseName, double actualAmountPaid, double goodTotalPrices, double discountAmount){
        this.actualAmountPaid=actualAmountPaid;
        this.consumerId=consumerId;
        this.discountAmount=discountAmount;
        this.deliveredAeraId=deliveredAeraId;
        this.goodsId=goodsId;
        this.deliveredName=deliveredName;
        this.deliveredDetailedAddress=deliveredDetailedAddress;
        this.deliveredPhone=deliveredPhone;
        this.goodTotalPrices=goodTotalPrices;
        this.goodsnumber=goodsnumber;
        this.warehouseName=warehouseName;
        this.warehouseAeraId=warehouseAeraId;
        this.warehouseDetailedAddress=warehouseDetailedAddress;
        this.warehousePhone=warehousePhone;
        this.orderId=orderId;
        this.orderStatus=orderStatus;
        this.orderPaymentMethod=orderPaymentMethod;
        this.consumerId=consumerId;
        this.orderTime=orderTime;
        this.shopId=shopId;
        this.logisticsSingle=logisticsSingle;
    }

    public double getActualAmountPaid() {
        return actualAmountPaid;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public int getDeliveredAeraId() {
        return deliveredAeraId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public double getGoodTotalPrices() {
        return goodTotalPrices;
    }

    public int getGoodsnumber() {
        return goodsnumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getShopId() {
        return shopId;
    }

    public int getWarehouseAeraId() {
        return warehouseAeraId;
    }

    public String getConsumerId() {
        return consumerId;
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

    public String getLogisticsSingle() {
        return logisticsSingle;
    }

    public String getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
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

    public Time getOrderTime() {
        return orderTime;
    }

    public void setActualAmountPaid(double actualAmountPaid) {
        this.actualAmountPaid = actualAmountPaid;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public void setDeliveredAeraId(int deliveredAeraId) {
        this.deliveredAeraId = deliveredAeraId;
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

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsnumber(int goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    public void setLogisticsSingle(String logisticsSingle) {
        this.logisticsSingle = logisticsSingle;
    }

    public void setGoodTotalPrices(double goodTotalPrices) {
        this.goodTotalPrices = goodTotalPrices;
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

    public void setWarehouseAeraId(int warehouseAeraId) {
        this.warehouseAeraId = warehouseAeraId;
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
}
