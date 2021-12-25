package cn.edu.zjut.action;

import cn.edu.zjut.po.Comment;
import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.po.Goods;
import cn.edu.zjut.service.CommentService;
import cn.edu.zjut.service.ConsumerService;
import cn.edu.zjut.service.GoodsService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReviewCommentAction implements SessionAware {

    CommentService commentService;
    GoodsService goodsService;
    ConsumerService consumerService;
    private Map<String, Object> session;
    String commentId;
    String goodsId;
    String consumerId;
    String judge;

    public String getConsumerId() {
        return consumerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public void setConsumerService(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    public ConsumerService getConsumerService() {
        return consumerService;
    }


    public String getCommentId() {
        return commentId;
    }

    public String getJudge() {
        return judge;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String displayCommentToReview() {
        List<Comment> comments = commentService.getAllCommentWithoutReview();
        session.put("comments", comments);
        return "success";
    }

    public String commentJudge() {
        if (Objects.equals(judge, "true")) {
            commentService.commentPass(Integer.parseInt(commentId));
        } else {
            commentService.commentNotPass(Integer.parseInt(commentId));
        }
        return "success";
    }

    public String reviewDetail() {
        Comment comment = commentService.getCommentById(Integer.parseInt(commentId));
        session.put("comment", comment);
        Goods goods = goodsService.getGoodsById(Integer.parseInt(goodsId));
        Consumer consumer = consumerService.getConsumerById(Integer.parseInt(consumerId));
        session.put("goods", goods);
        session.put("consumer", consumer);
        return "success";
    }
}

