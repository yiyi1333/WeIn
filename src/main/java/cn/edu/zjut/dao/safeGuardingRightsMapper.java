package cn.edu.zjut.dao;

import cn.edu.zjut.po.safeGuardingRights;
import cn.edu.zjut.po.safeGuardingRightsProgress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface safeGuardingRightsMapper {
    //获得所有维权
    public List<safeGuardingRights> getAllsafeGuardingRights();

    //根据id获得维权
    public safeGuardingRights selectsafeGuardingRightsById(@Param("safeGuardingRightsId") Integer safeGuardingRightsId);

    // 根据条件选择维权
    public List<safeGuardingRights> selectsafeGuardingRights(safeGuardingRights safeGuardingRights);

    // 更新维权
    public void updatesafeGuardingRights(safeGuardingRights safeGuardingRights);

    // 根据维权号获得维权详细
    public List<safeGuardingRightsProgress> getsafeGuardingRightsProgressById(@Param("safeGuardingRightsId") Integer safeGuardingRightsId);
}
