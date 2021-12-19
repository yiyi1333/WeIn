package cn.edu.zjut.dao;

import cn.edu.zjut.po.ElectronicContracts;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class ElectronicContractsImpl implements ElectronicContractsMapper{
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

    public void addElectronicContracts(ElectronicContracts electronicContracts) {
        System.out.println("execute --addElectronicContracts()-- method.");
        sqlSession.getMapper(ElectronicContractsMapper.class).addElectronicContracts(electronicContracts);
    }

    public List queryElectronicContractsByEnterpriseId(int id) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByEnterpriseId(id);
    }

    public void disableContracts(int id) {
        sqlSession.getMapper(ElectronicContractsMapper.class).disableContracts(id);
    }

    public List queryElectronicContractsByEnterpriseAgencyId(int agencyid) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByEnterpriseAgencyId(agencyid);
    }

    public void changeStateElectronicContracts(int agencyid) {
        sqlSession.getMapper(ElectronicContractsMapper.class).changeStateElectronicContracts(agencyid);
    }

    public List queryElectronicContractsByShopId(int shopid) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByShopId(shopid);
    }

    @Override
    public ElectronicContracts queryElectronicContractsByGoodsIdAndDepartmentId(int goodsId, int deparatmentId) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByGoodsIdAndDepartmentId(goodsId, deparatmentId);
    }
}

