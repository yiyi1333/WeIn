package cn.edu.zjut.po;

public class OrderGood {
    int id;
    int goodId;
    int orderId;
    int num;

    public OrderGood() {
    }

    public int getOrderId() {
        return orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }
}