package cn.edu.zjut.dao;

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
        System.out.println("execute--addOrder--dao");
        return sqlSession.getMapper(OrdersMapper.class).addOrder(orders);
    }

    @Override
    public void addLogisticsSingleList(Orders orders) {
        System.out.println("execute --addLogisticsSingleList-- dao");
        sqlSession.getMapper(OrdersMapper.class).addLogisticsSingleList(orders);
    }

    @Override
    public void updateOrder(Orders orders) {
        System.out.println("execute --updateOrder-- dao");
        sqlSession.getMapper(OrdersMapper.class).updateOrder(orders);
    }

    @Override
    public List<Orders> getAllFundFlow() {
        System.out.println("execute--getAllFundFlow--dao");
        return sqlSession.getMapper(OrdersMapper.class).getAllFundFlow();
    }

    @Override
    public List<Orders> getFundFlowByDate(String date) {
        System.out.println("execute--getFundFlowByDate--dao");
        return sqlSession.getMapper(OrdersMapper.class).getFundFlowByDate(date);
    }
}
