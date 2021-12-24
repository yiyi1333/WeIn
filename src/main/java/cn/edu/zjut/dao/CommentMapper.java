package cn.edu.zjut.dao;

import cn.edu.zjut.po.Comment;

import java.util.List;

public interface CommentMapper {
    public List<Comment> getAllCommentWithoutReview();

    public void commentNotPass(int id);

    public void commentPass(int id);

    public Comment getCommentById(int id);

    public List<Comment> getCommentByGoodId(int id);
}