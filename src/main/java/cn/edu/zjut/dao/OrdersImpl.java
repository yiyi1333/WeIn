package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderGood;
import cn.edu.zjut.po.OrderShow;
import cn.edu.zjut.po.Orders;
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

    @Override
    public Orders selectOrdersById(Integer orderId) {
        System.out.println("execute--selectOrdersById--dao");
        return sqlSession.getMapper(OrdersMapper.class).selectOrdersById(orderId);
    }

    @Override
    public List<Orders> selectOrders(Orders orders) {
        System.out.println("execute--selectOrders--dao");
        return sqlSession.getMapper(OrdersMapper.class).selectOrders(orders);
    }

    @Override
    public Integer addOrder(Orders orders) {
        return sqlSession.getMapper(OrdersMapper.class).addOrder(orders);
    }

    @Override
    public List<OrderShow> showAllOrder(Integer customerId) {
        return sqlSession.getMapper(OrdersMapper.class).showAllOrder(customerId);
    }

    @Override
    public OrderShow showOrderDetail(Integer orderId) {
        return sqlSession.getMapper(OrdersMapper.class).showOrderDetail(orderId);
    }
}
