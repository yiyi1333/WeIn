package cn.edu.zjut.dao;

import cn.edu.zjut.po.WareHouseAddress;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class WareHouseAddressImpl implements WareHouseAddressMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<WareHouseAddress> getAllWareHouseAddress() {
        System.out.println("execute --getAllWareHouseAddress()-- method.");
        return sqlSession.getMapper(WareHouseAddressMapper.class).getAllWareHouseAddress();
    }
}
