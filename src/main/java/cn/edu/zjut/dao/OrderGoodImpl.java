package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderGood;
import org.mybatis.spring.SqlSessionTemplate;

public class OrderGoodImpl implements OrderGoodMapper {
    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public void addOrderGood(OrderGood orderGood) {
        sqlSession.getMapper(OrderGoodMapper.class).addOrderGood(orderGood);
    }
}
