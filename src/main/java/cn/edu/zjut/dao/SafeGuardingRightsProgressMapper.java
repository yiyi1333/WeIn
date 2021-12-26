package cn.edu.zjut.dao;

import cn.edu.zjut.po.SafeGuardingRightsProgress;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface SafeGuardingRightsProgressMapper {
    // 根据safeGuardingRightsProgressId获取维权状态
    public List<SafeGuardingRightsProgress> getsafeGuardingRightsProgressById(@Param("safeGuardingRightsProgressId") Integer safeGuardingRightsProgressId);

    // 插入新数据
    public void addsafeGuardingRightsProgress(SafeGuardingRightsProgress safeGuardingRightsProgress);

    // 插入新方式
    public Integer addSafeGuardingRightsProgress(@Param("safeGuardingRightsProgressStatus") String safeGuardingRightsProgressStatus,
                                                 @Param("safeGuardingRightsProgressTime") Time safeGuardingRightsProgressTime,
                                                 @Param("safeGuardingRightsProgressDate") Date safeGuardingRightsProgressDate,
                                                 @Param("safeGuardingRightsId") Integer safeGuardingRightsId);
}
