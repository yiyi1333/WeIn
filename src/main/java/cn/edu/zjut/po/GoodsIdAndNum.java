package cn.edu.zjut.po;

public class GoodsIdAndNum {
    private String goodsId;
    private String goodsNum;

    @Override
    public String toString() {
        return "GoodsIdAndNum{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                '}';
    }

    public GoodsIdAndNum() {
    }

    public GoodsIdAndNum(String goodsId, String goodsNum) {
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
}
