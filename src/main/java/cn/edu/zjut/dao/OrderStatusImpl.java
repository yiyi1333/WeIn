package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderStatus;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class OrderStatusImpl implements OrderStatusMapper {
    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public void addOrderStatus(OrderStatus orderStatus) {
        System.out.println("execute --addOrderStatus()-- dao.");
         sqlSession.getMapper(OrderStatusMapper.class).addOrderStatus(orderStatus);
    }

    @Override
    public List<OrderStatus> getOrderStatusById(Integer orderId) {
        System.out.println("execute --getOrderStatusById()-- dao.");
        return sqlSession.getMapper(OrderStatusMapper.class).getOrderStatusById(orderId);
    }

    @Override
    public List<OrderStatus> getOrderStatus(OrderStatus orderStatus) {
        System.out.println("execute --getOrderStatusById()-- dao.");
        return sqlSession.getMapper(OrderStatusMapper.class).getOrderStatus(orderStatus);
    }
}