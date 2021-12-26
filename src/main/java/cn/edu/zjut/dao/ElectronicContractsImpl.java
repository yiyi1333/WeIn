package cn.edu.zjut.dao;

import cn.edu.zjut.po.ElectronicContracts;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.Date;
import java.util.List;

public class ElectronicContractsImpl implements ElectronicContractsMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    @Override
    public List<ElectronicContracts> queryElectronicContracts() {
        System.out.println("execute --queryElectronicContracts()-- method.");
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContracts();
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void addElectronicContracts(ElectronicContracts electronicContracts) {
        System.out.println("execute --addElectronicContracts()-- method.");
        sqlSession.getMapper(ElectronicContractsMapper.class).addElectronicContracts(electronicContracts);
    }

    @Override
    public List queryElectronicContractsByEnterpriseId(int id) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByEnterpriseId(id);
    }

    @Override
    public void disableContracts(int id) {
        sqlSession.getMapper(ElectronicContractsMapper.class).disableContracts(id);
    }

    @Override
    public List queryElectronicContractsByEnterpriseAgencyId(int agencyid) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByEnterpriseAgencyId(agencyid);
    }

    @Override
    public void changeStateElectronicContracts(int agencyid, int electronicContractsid, int state) {
        sqlSession.getMapper(ElectronicContractsMapper.class).changeStateElectronicContracts(agencyid,electronicContractsid,state);
    }

    @Override
    public void changeStateElectronicContracts2(int shopid, int electronicContractsid, int state) {
        sqlSession.getMapper(ElectronicContractsMapper.class).changeStateElectronicContracts2(shopid,electronicContractsid,state);
    }

//    @Override
//    public void changeStateElectronicContracts2(int agencyid) {
//
//    }

    @Override
    public List queryElectronicContractsByShopId(int shopid) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByShopId(shopid);
    }

    @Override
    public ElectronicContracts queryElectronicContractsByGoodsIdAndDepartmentId(int goodsId, int deparatmentId, Date now) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByGoodsIdAndDepartmentId(goodsId, deparatmentId, now);
    }

    @Override
    public List queryElectronicContractsLike(ElectronicContracts electronicContracts) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsLike(electronicContracts);
    }

    @Override
    public ElectronicContracts queryElectronicContractsByGoodsIdDepartmentId(int goodsId, int deparatmentId) {
        return sqlSession.getMapper(ElectronicContractsMapper.class).queryElectronicContractsByGoodsIdDepartmentId(goodsId, deparatmentId);
    }
}

