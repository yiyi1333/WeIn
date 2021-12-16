package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface CartMapper {
    public ArrayList getConsumerCart(@Param("consumerId") int consumerId);
    public Integer getCartNum(@Param("consumerID") int consumerId, @Param("goodsId")int goodsId);
    public Integer addOneToCart(@Param("consumerID") int consumerId, @Param("goodsId") int goodsId);
    public Integer insertCart(@Param("consumerID") int consumerId, @Param("goodsId") int goodsId);
}
