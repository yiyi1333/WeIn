package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseAgency;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class EnterpriseAgencyImpl implements EnterpriseAgencyMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<EnterpriseAgency> getAllEnterpriseAgency() {
        System.out.println("execute --getAllEnterpriseAgency()-- method.");
        return sqlSession.getMapper(EnterpriseAgencyMapper.class).getAllEnterpriseAgency();
    }

    @Override
    public void addEnterpriseAgency(EnterpriseAgency enterpriseAgency) {
        System.out.println("execute --registerEnterpriseagency()-- method.");
        sqlSession.getMapper(EnterpriseAgencyMapper.class).addEnterpriseAgency(enterpriseAgency);
    }

    @Override
    public void deleteEnterpriseagency(int id) {
        System.out.println("execute --deleteEnterpriseagency()-- method.");
        sqlSession.getMapper(EnterpriseAgencyMapper.class).deleteEnterpriseagency(id);
    }

    @Override
    public EnterpriseAgency getEnterpriseAgencyByAccount(String acount) {
        return sqlSession.getMapper(EnterpriseAgencyMapper.class).getEnterpriseAgencyByAccount(acount);
    }
}
