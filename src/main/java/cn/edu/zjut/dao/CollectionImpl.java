package cn.edu.zjut.dao;

import cn.edu.zjut.po.Collection;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class CollectionImpl implements CollectionMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public Integer addCollection(Integer customerId, Integer goodsId, Date date, Time time) {
        SqlSession session = sqlSession.getSqlSessionFactory().openSession();
        CollectionMapper collectionMapper = sqlSession.getMapper(CollectionMapper.class);
        Integer line = null;
        try {
            line = collectionMapper.addCollection(customerId, goodsId, date, time);
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
    public List<Collection> selectAllCollection(Integer customerId) {
        return sqlSession.getMapper(CollectionMapper.class).selectAllCollection(customerId);
    }
}
