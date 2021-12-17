package cn.edu.zjut.dao;

import cn.edu.zjut.po.ElectronicContracts;

import java.util.List;

public interface ElectronicContractsMapper {
    public List<ElectronicContracts> queryElectronicContracts();
    public void addElectronicContracts(ElectronicContracts electronicContracts);
    public List queryElectronicContractsByEnterpriseId(int id);
    public void disableContracts(int id);
    public List queryElectronicContractsByEnterpriseAgencyId(int agencyid);
    public void changeStateElectronicContracts(int agencyid);
    public List queryElectronicContractsByShopId(int shopid);
}
