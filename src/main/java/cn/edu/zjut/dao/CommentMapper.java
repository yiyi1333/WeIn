package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    public Integer addComment(@Param("consumerId")Integer consumerId, @Param("goodsId")Integer goodsId,
                              @Param("message") String message, @Param("rate") Integer rate,
                              @Param("image") String image, @Param("state") Integer state, @Param("orderId") Integer orderId);
}
