package cn.edu.zjut.dao;

import cn.edu.zjut.po.Area;
import cn.edu.zjut.po.WareHouseAddress;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public void addWareHouseAddress(WareHouseAddress wareHouseAddress) {
        System.out.println("execute--addWareHouseAddress--dao");
        sqlSession.getMapper(WareHouseAddressMapper.class).addWareHouseAddress(wareHouseAddress);
    }

    @Override
    public List<WareHouseAddress> selectWareHouseAddress(WareHouseAddress wareHouseAddress) {
        System.out.println("execute--selectWareHouseAddress--dao");
        return sqlSession.getMapper(WareHouseAddressMapper.class).selectWareHouseAddress(wareHouseAddress);
    }

    @Override
    public void updateWareHouseAddress(WareHouseAddress wareHouseAddress) {
        System.out.println("execute--updateWareHouseAddress--dao");
        sqlSession.getMapper(WareHouseAddressMapper.class).updateWareHouseAddress(wareHouseAddress);
    }

    @Override
    public WareHouseAddress selectWareHouseAddressById(Integer warehouseId) {
        System.out.println("execute--selectWareHouseAddressById--dao");
        return sqlSession.getMapper(WareHouseAddressMapper.class).selectWareHouseAddressById(warehouseId);
    }

    @Override
    public void deleteWareHouseAddressById(Integer warehouseId) {
        System.out.println("execute--deleteWareHouseAddressById--dao");
        sqlSession.getMapper(WareHouseAddressMapper.class).deleteWareHouseAddressById(warehouseId);
    }

    @Override
    public void deleteWareHouseAddressByIds(String tag) {
        System.out.println("execute--deleteWareHouseAddressByIds--dao");
        sqlSession.getMapper(WareHouseAddressMapper.class).deleteWareHouseAddressByIds(tag);
    }


}
