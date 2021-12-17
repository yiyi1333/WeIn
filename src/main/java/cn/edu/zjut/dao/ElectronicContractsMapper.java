package cn.edu.zjut.dao;

import cn.edu.zjut.po.ElectronicContracts;

import java.util.List;

public interface ElectronicContractsMapper {
    public List<ElectronicContracts> queryElectronicContracts();
    public void addElectronicContracts(ElectronicContracts electronicContracts);
}
