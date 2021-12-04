package cn.edu.zjut.service;



import cn.edu.zjut.dao.OrdersMapper;
import cn.edu.zjut.po.Orders;

import java.util.List;

public class OrdersService {
    private OrdersMapper ordersDao;

    public OrdersMapper getOrdersDao() {
        return ordersDao;
    }

    public void setOrdersDao(OrdersMapper ordersDao) {
        this.ordersDao = ordersDao;
    }

    public List<Orders> getAllOrders() {
        System.out.println("execute --getAllOrders()-- method.");
        return ordersDao.getAllOrders();
    }
}
