package cn.edu.zjut.dao;

import cn.edu.zjut.po.ElectronicContracts;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class ElectronicContractsImpl {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public List<ElectronicContracts> queryElectronicContracts() {
        System.out.println("execute --queryElectronicContracts()-- method.");
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContracts();
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

}
