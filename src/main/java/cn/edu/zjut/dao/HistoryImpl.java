package cn.edu.zjut.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.sql.Time;
import java.sql.Date;

public class HistoryImpl implements HistoryMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public Integer addHistory(Integer customerId, Integer goodsId, Date date, Time time) {
        SqlSession session = sqlSession.getSqlSessionFactory().openSession();
        HistoryMapper historyMapper = sqlSession.getMapper(HistoryMapper.class);
        Integer line = null;
        try {
            line = historyMapper.addHistory(customerId, goodsId, date, time);
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
