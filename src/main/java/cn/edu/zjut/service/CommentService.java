package cn.edu.zjut.service;

import cn.edu.zjut.dao.CommentMapper;

public class CommentService {
    private CommentMapper commentDao;

    public CommentMapper getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentMapper commentDao) {
        this.commentDao = commentDao;
    }

    public boolean submitComment(Integer consumerId, Integer goodsId, String message, Integer rate, String image,  Integer orderId){
        Integer line = commentDao.addComment(consumerId, goodsId, message, rate, image, 0, orderId);
        if( line != null && line != 0){
            return true;
        }
        return false;
    }
}
