package cn.edu.zjut.dao;

import cn.edu.zjut.po.SafeGuardingRights;
import cn.edu.zjut.po.SafeGuardingRightsProgress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SafeGuardingRightsMapper {
    //获得所有维权
    public List<SafeGuardingRights> getAllsafeGuardingRights();

    //根据id获得维权
    public SafeGuardingRights selectsafeGuardingRightsById(@Param("safeGuardingRightsId") Integer safeGuardingRightsId);

    // 根据条件选择维权
    public List<SafeGuardingRights> selectsafeGuardingRights(SafeGuardingRights safeGuardingRights);

    // 更新维权
    public void updatesafeGuardingRights(SafeGuardingRights safeGuardingRights);

    // 根据维权号获得维权详细
    public List<SafeGuardingRightsProgress> getsafeGuardingRightsProgressById(@Param("safeGuardingRightsId") Integer safeGuardingRightsId);

    public Integer addSafeGuardingRightsRecord(@Param("goodsId") Integer goodsId, @Param("goodsNum") Integer goodsNum,
                                               @Param("descript")String descript, @Param("imagePath")String imagePath,
                                               @Param("orderId") Integer orderId, @Param("Type") String type,
                                               @Param("status") String status);

    public SafeGuardingRights selectSafeGuardingRightsByGoodIdAndOrderId(@Param("goodId") Integer goodId, @Param("ordersId") Integer orderId);


}
