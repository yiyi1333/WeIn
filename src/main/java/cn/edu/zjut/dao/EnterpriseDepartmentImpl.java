package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseUser;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class EnterpriseDepartmentImpl implements EnterpriseDepartmentMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<EnterpriseUser> getAllEnterpriseUser() {
        System.out.println("execute--getEnterpriseUser--dao");
        return sqlSession.getMapper(EnterpriseDepartmentMapper.class).getAllEnterpriseUser();
    }
}
