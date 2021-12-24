package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;

public interface SafeGuardingRightsMapper {
    public Integer addSafeGuardingRightsRecord(@Param("goodsId") Integer goodsId, @Param("goodsNum") Integer goodsNum,
                                               @Param("descript")String descript, @Param("imagePath")String imagePath,
                                               @Param("orderId") Integer orderId, @Param("Type") String type,
                                               @Param("status") String status);
}
