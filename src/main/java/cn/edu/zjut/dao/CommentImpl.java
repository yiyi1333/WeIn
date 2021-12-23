package cn.edu.zjut.dao;

import cn.edu.zjut.po.Comment;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class CommentImpl implements CommentMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Comment> getAllCommentWithoutReview() {
        return sqlSession.getMapper(CommentMapper.class).getAllCommentWithoutReview();
    }

    @Override
    public void commentNotPass(int id) {
        sqlSession.getMapper(CommentMapper.class).commentNotPass(id);
    }

    @Override
    public void commentPass(int id) {
        sqlSession.getMapper(CommentMapper.class).commentPass(id);
    }

    @Override
    public Comment getCommentById(int id) {
        return sqlSession.getMapper(CommentMapper.class).getCommentById(id);
    }
}
