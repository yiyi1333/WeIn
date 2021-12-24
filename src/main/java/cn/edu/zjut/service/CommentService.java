package cn.edu.zjut.service;

import cn.edu.zjut.dao.CommentMapper;
import cn.edu.zjut.po.Comment;

import java.util.List;

public class CommentService {
    CommentMapper commentMapper;


    public CommentMapper getCommentMapper() {
        return commentMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
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