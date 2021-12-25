package cn.edu.zjut.dao;

import cn.edu.zjut.po.SafeGuardingRightsProgress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SafeGuardingRightsProgressMapper {
    // 根据safeGuardingRightsProgressId获取维权状态
    public List<SafeGuardingRightsProgress> getsafeGuardingRightsProgressById(@Param("safeGuardingRightsProgressId") Integer safeGuardingRightsProgressId);

    // 插入新数据
    public void addsafeGuardingRightsProgress(SafeGuardingRightsProgress safeGuardingRightsProgress);
}
