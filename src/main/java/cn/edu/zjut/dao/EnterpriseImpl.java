package cn.edu.zjut.dao;

import cn.edu.zjut.po.Enterprise;
import org.mybatis.spring.SqlSessionTemplate;

public class EnterpriseImpl implements EnterpriseMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Enterprise getEnterpriseById(int id) {
        return sqlSession.getMapper(EnterpriseMapper.class).getEnterpriseById(id);
    }

}
