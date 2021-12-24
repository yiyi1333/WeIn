package cn.edu.zjut.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

public class CommentImpl implements CommentMapper{
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
}
