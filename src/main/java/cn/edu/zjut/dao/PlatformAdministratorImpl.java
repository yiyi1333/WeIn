package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.PlatformAdministrator;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class PlatformAdministratorImpl implements PlatformAdministratorMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<PlatformAdministrator> getAllPlatformAdministrator() {
        System.out.println("execute --getAllPlatformAdministrator()-- method.");
        return sqlSession.getMapper(PlatformAdministratorMapper.class).getAllPlatformAdministrator();
    }
}
