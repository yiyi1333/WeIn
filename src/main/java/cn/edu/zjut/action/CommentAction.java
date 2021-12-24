package cn.edu.zjut.action;

import cn.edu.zjut.service.CommentService;

public class CommentAction {
    private CommentService commentService;
    private String rate;
    private String imgpath;
    private String descript;
    private String consumerId;
    private String orderId;
    private String goodsId;
    private String statusMes;

    public String getStatusMes() {
        return statusMes;
    }

    public void setStatusMes(String statusMes) {
        this.statusMes = statusMes;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String submitComment(){
        if(commentService.submitComment(Integer.parseInt(consumerId), Integer.parseInt(goodsId), descript, Integer.parseInt(rate), imgpath, Integer.parseInt(orderId))){
            statusMes = "评价成功";
        }else{
            statusMes = "评价失败";
        }
        return "success";
    }
}
