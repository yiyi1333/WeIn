package cn.edu.zjut.po;

public class OrderGood {
    int goodId;
    int orderId;
    int num;
    double singlePieceActualPrice;

    public double getSinglePieceActualPrice() {
        return singlePieceActualPrice;
    }

    public void setSinglePieceActualPrice(double singlePieceActualPrice) {
        this.singlePieceActualPrice = singlePieceActualPrice;
    }

    public OrderGood() {
    }

    public int getOrderId() {
        return orderId;
    }

    public int getGoodId() {
        return goodId;
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

    public void setNum(int num) {
        this.num = num;
    }
}
