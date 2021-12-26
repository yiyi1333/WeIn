package cn.edu.zjut.dao;

import cn.edu.zjut.po.ElectronicContracts;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ElectronicContractsMapper {
    public List<ElectronicContracts> queryElectronicContracts();

    public void addElectronicContracts(ElectronicContracts electronicContracts);

    public List queryElectronicContractsByEnterpriseId(int id);

    public void disableContracts(int id);

    public List queryElectronicContractsByEnterpriseAgencyId(int agencyid);

    public void changeStateElectronicContracts(int agencyid);

    public List queryElectronicContractsByShopId(int shopid);

    public ElectronicContracts queryElectronicContractsByGoodsIdAndDepartmentId(@Param("goodsId") int goodsId, @Param("deparatmentId") int deparatmentId, @Param("now") Date now);

    public List queryElectronicContractsLike(ElectronicContracts electronicContracts);

    public ElectronicContracts queryElectronicContractsByGoodsIdDepartmentId(@Param("goodsId") int goodsId, @Param("deparatmentId") int deparatmentId);

    public void changeStateElectronicContracts2(@Param("shopId") int shopid, @Param("electronicContractsid") int electronicContractsid, @Param("state") int state);

    public void changeStateElectronicContracts2(int agencyid);
}
