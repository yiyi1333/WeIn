package cn.edu.zjut.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import cn.edu.zjut.po.Comment;
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
    public Integer addComment(Integer consumerId, Integer goodsId, String message, Integer rate, String image, Integer state, Integer orderId) {
        SqlSession session = sqlSession.getSqlSessionFactory().openSession();
        CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
        Integer line = null;
        try {
            line = commentMapper.addComment(consumerId, goodsId, message, rate, image, state, orderId);
            System.out.println(line);
            session.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return line;
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

    @Override
    public List<Comment> getCommentByGoodId(int id) {
        return sqlSession.getMapper(CommentMapper.class).getCommentByGoodId(id);
    }
}
