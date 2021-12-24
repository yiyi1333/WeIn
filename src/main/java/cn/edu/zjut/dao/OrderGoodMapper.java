package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodMapper {

    // 添加商品
    public void addOrderGood(OrderGood orderGood);

    // 根据orderId获取商品
    public List<OrderGood> getGoodsById(@Param("orderId") Integer orderId);

    // 根据orderId和goodId获取商品
    public OrderGood selectOrderGood(OrderGood orderGood);

}
