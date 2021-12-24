package cn.edu.zjut.dao;

import cn.edu.zjut.po.safeGuardingRightsProgress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface safeGuardingRightsProgressMapper {
    // 根据safeGuardingRightsProgressId获取维权状态
    public List<safeGuardingRightsProgress> getsafeGuardingRightsProgressById(@Param("safeGuardingRightsProgressId") Integer safeGuardingRightsProgressId);

    // 插入新数据
    public void addsafeGuardingRightsProgress(safeGuardingRightsProgress safeGuardingRightsProgress);
}
