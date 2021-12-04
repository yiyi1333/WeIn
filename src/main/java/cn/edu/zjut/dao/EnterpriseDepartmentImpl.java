package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseDepartment;
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

    @Override
    public void addEnterpriseDepartment(EnterpriseDepartment enterpriseDepartment) {
        System.out.println("execute--addEnterpriseDepartment--dao");
        sqlSession.getMapper(EnterpriseDepartmentMapper.class).addEnterpriseDepartment(enterpriseDepartment);
    }

    @Override
    public List<EnterpriseDepartment> getAllEnterpriseDepartment() {
        System.out.println("execute--getAllEnterpriseDepartment--dao");
        return sqlSession.getMapper(EnterpriseDepartmentMapper.class).getAllEnterpriseDepartment();
    }
}
