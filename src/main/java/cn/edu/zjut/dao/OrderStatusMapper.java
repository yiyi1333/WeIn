package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderStatusMapper {

    public void addOrderStatus(OrderStatus orderStatus);

    // 根据orderId获取订单状态列表
    public List<OrderStatus> getOrderStatusById(@Param("orderId") Integer orderId);

    //根据orderId和状态获取订单状态详情
    public List<OrderStatus> getOrderStatus(OrderStatus orderStatus);
}

