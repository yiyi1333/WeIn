package cn.edu.zjut.po;

public class DrawBack {
    private int orderId;
    private int goodsId;
    private double money;
    private int goodsNum;
    private String type;

    public String getType() {
        return type;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public double getMoney() {
        return money;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}