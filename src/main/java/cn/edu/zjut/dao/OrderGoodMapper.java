package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodMapper {

    public void addOrderGood(OrderGood orderGood);

    // 根据orderId获取商品
    public List<OrderGood> getGoodsById(@Param("orderId") Integer orderId);
}
