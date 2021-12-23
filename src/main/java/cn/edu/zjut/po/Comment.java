package cn.edu.zjut.po;

public class Comment {
    int commentId;
    int consumerId;
    int goodsId;
    String message;
    int rate;
    String image;
    int state;

    public Comment(){}

    public int getCommentId() {
        return commentId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public int getRate() {
        return rate;
    }

    public int getState() {
        return state;
    }

    public String getImage() {
        return image;
    }

    public String getMessage() {
        return message;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setState(int state) {
        this.state = state;
    }
}
