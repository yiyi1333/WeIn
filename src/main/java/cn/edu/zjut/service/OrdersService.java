package cn.edu.zjut.service;



import cn.edu.zjut.dao.OrdersMapper;
import cn.edu.zjut.po.Orders;
import cn.edu.zjut.po.WareHouseAddress;

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

    public List<Orders> selectOrders(Orders orders){
        System.out.println("execute --selectOrders()-- method.");
        return ordersDao.selectOrders(orders);
    }

    public Orders selectOrderById(Integer orderId){
        System.out.println("execute --selectOrdersById()-- method.");
        return ordersDao.selectOrdersById(orderId);
    }
}
