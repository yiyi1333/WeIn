package cn.edu.zjut.dao;

import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.Orders;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class OrdersImpl implements OrdersMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Orders> getAllOrders() {
        System.out.println("execute --getAllOrders()-- method.");
        return sqlSession.getMapper(OrdersMapper.class).getAllOrders();
    }
}
