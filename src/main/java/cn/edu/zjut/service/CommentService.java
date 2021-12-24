package cn.edu.zjut.service;

import cn.edu.zjut.dao.CommentMapper;
import cn.edu.zjut.po.Comment;

import java.util.List;

public class CommentService {
    private CommentMapper commentDao;
    CommentMapper commentMapper;

    public CommentMapper getCommentMapper() {
        return commentMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
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

    public List<Comment> getAllCommentWithoutReview() {
        return commentMapper.getAllCommentWithoutReview();
    }

    public void commentPass(int id) {
        commentMapper.commentPass(id);
    }

    public void commentNotPass(int id) {
        commentMapper.commentNotPass(id);
    }

    public Comment getCommentById(int id) {
        return commentMapper.getCommentById(id);
    }

    public List<Comment> getCommentByGoodId(int id){
        return commentMapper.getCommentByGoodId(id);
    }
}
