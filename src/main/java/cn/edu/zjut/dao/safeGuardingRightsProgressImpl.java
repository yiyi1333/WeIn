package cn.edu.zjut.dao;

import cn.edu.zjut.po.safeGuardingRightsProgress;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class safeGuardingRightsProgressImpl implements safeGuardingRightsProgressMapper{
    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public List<safeGuardingRightsProgress> getsafeGuardingRightsProgressById(Integer safeGuardingRightsProgressId) {
        return sqlSession.getMapper(safeGuardingRightsProgressMapper.class).getsafeGuardingRightsProgressById(safeGuardingRightsProgressId);
    }

    @Override
    public void addsafeGuardingRightsProgress(safeGuardingRightsProgress safeGuardingRightsProgress) {
        sqlSession.getMapper(safeGuardingRightsProgressMapper.class).addsafeGuardingRightsProgress(safeGuardingRightsProgress);
    }
}
