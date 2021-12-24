package cn.edu.zjut.service;

import cn.edu.zjut.dao.OrderStatusMapper;
import cn.edu.zjut.po.OrderStatus;

import java.util.List;

public class OrderStatusService {
    private OrderStatusMapper orderStatusDao;

    public OrderStatusMapper getOrderStatusDao() {
        return orderStatusDao;
    }

    public void setOrderStatusDao(OrderStatusMapper orderStatusDao) {
        this.orderStatusDao = orderStatusDao;
    }

    public void addOrderStatus(OrderStatus orderStatus){
        orderStatusDao.addOrderStatus(orderStatus);
    }

    public List<OrderStatus> getOrderStatusById(Integer orderId){
        return orderStatusDao.getOrderStatusById(orderId);
    }
    public List<OrderStatus> getOrderStatus(OrderStatus orderStatus){
        return orderStatusDao.getOrderStatus(orderStatus);
    }

}
