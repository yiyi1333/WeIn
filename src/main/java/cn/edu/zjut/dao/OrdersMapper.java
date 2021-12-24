package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderGood;
import cn.edu.zjut.po.OrderShow;
import cn.edu.zjut.po.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    public List<Orders> getAllOrders();
    public Orders selectOrdersById(@Param("orderId") Integer orderId);
    public List<Orders> selectOrders(Orders orders);
    public Integer addOrder(Orders orders);
    public void addLogisticsSingleList(Orders orders);
    public void updateOrder(Orders orders);
    public List<Orders> getAllFundFlow();//获取店铺所有流水
    public List<Orders> getFundFlowByDate(String date);
    public List<OrderShow> showAllOrder(@Param("customerId") Integer customerId);
    public OrderShow showOrderDetail(@Param("orderId") Integer orderId);
    public List<OrderShow> showStatusOrder(@Param("customerId") Integer customerId, @Param("status") String status);
}
