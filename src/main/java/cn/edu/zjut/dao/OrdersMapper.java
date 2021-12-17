package cn.edu.zjut.dao;

import cn.edu.zjut.po.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    public List<Orders> getAllOrders();
    public Orders selectOrdersById(@Param("orderId") Integer orderId);
    public List<Orders> selectOrders(Orders orders);
}
