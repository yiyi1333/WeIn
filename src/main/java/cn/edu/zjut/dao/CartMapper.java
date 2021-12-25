package cn.edu.zjut.dao;

import cn.edu.zjut.po.CartRecord;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface CartMapper {
    public ArrayList getConsumerCart(@Param("consumerId") int consumerId);
    public Integer getCartNum(@Param("consumerID") int consumerId, @Param("goodsId")int goodsId);
    public Integer addOneToCart(@Param("consumerID") int consumerId, @Param("goodsId") int goodsId);
    public Integer insertCart(@Param("consumerID") int consumerId, @Param("goodsId") int goodsId);
    public CartRecord getRecord(@Param("consumerId") Integer consumerId, @Param("goodsId") Integer goodsId);
    public Integer removeRecord(@Param("consumerId") Integer consumerId, @Param("goodsId") Integer goodsId);
    public Integer updateRecord(@Param("consumerId") Integer consumerId, @Param("goodsId") Integer goodsId, @Param("num") Integer num);
    public List<CartRecord> getRecordAll(@Param("consumerId") Integer consumerId);
}
