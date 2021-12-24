package cn.edu.zjut.po;

import java.sql.Time;
import java.util.Date;

public class OrderStatus {
    private int orderStatusId;//订单状态编号
    private String orderStatusName;//订单状态
    private Date orderStatusDate;//更改日期
    private Time orderStatusTime;//更改时间
    private int orderId;//订单编号

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderStatusDate() {
        return orderStatusDate;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public Time getOrderStatusTime() {
        return orderStatusTime;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatusDate(Date orderStatusDate) {
        this.orderStatusDate = orderStatusDate;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public void setOrderStatusTime(Time orderStatusTime) {
        this.orderStatusTime = orderStatusTime;
    }
}
