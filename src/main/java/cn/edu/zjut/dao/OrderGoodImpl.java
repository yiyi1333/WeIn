package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderGood;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

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

    @Override
    public List<OrderGood> getGoodsById(Integer orderId) {
        return sqlSession.getMapper(OrderGoodMapper.class).getGoodsById(orderId);
    }

    @Override
    public OrderGood selectOrderGood(OrderGood orderGood) {
        return sqlSession.getMapper(OrderGoodMapper.class).selectOrderGood(orderGood);
    }
}
