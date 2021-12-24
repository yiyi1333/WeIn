package cn.edu.zjut.dao;

import cn.edu.zjut.po.SafeGuardingRights;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SafeGuardingRightsMapper {
    public Integer addSafeGuardingRightsRecord(@Param("goodsId") Integer goodsId, @Param("goodsNum") Integer goodsNum,
                                               @Param("descript")String descript, @Param("imagePath")String imagePath,
                                               @Param("orderId") Integer orderId, @Param("Type") String type,
                                               @Param("status") String status);

    public List<SafeGuardingRights> selectSafeGuardingRightsByGoodId(@Param("goodId") Integer goodId);
}
