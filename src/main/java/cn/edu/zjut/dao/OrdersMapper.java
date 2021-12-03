package cn.edu.zjut.dao;

import cn.edu.zjut.po.Orders;

import java.util.List;

public interface OrdersMapper {
    public List<Orders> getAllOrders();
    public Orders selectOrdersById(String orderId);
}
