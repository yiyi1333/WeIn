package cn.edu.zjut.dao;

import cn.edu.zjut.po.SafeGuardingRightsProgress;
import org.mybatis.spring.SqlSessionTemplate;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class SafeGuardingRightsProgressImpl implements SafeGuardingRightsProgressMapper {
    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public List<SafeGuardingRightsProgress> getsafeGuardingRightsProgressById(Integer safeGuardingRightsProgressId) {
        return sqlSession.getMapper(SafeGuardingRightsProgressMapper.class).getsafeGuardingRightsProgressById(safeGuardingRightsProgressId);
    }

    @Override
    public void addsafeGuardingRightsProgress(SafeGuardingRightsProgress safeGuardingRightsProgress) {
        sqlSession.getMapper(SafeGuardingRightsProgressMapper.class).addsafeGuardingRightsProgress(safeGuardingRightsProgress);
    }

    @Override
    public Integer addSafeGuardingRightsProgress(String safeGuardingRightsProgressStatus, Time safeGuardingRightsProgressTime, Date safeGuardingRightsProgressDate, Integer safeGuardingRightsId) {
        return sqlSession.getMapper(SafeGuardingRightsProgressMapper.class).addSafeGuardingRightsProgress(safeGuardingRightsProgressStatus, safeGuardingRightsProgressTime, safeGuardingRightsProgressDate, safeGuardingRightsId);
    }
}
