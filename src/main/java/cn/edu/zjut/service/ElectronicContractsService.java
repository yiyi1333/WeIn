package cn.edu.zjut.service;

import cn.edu.zjut.dao.ElectronicContractsImpl;
import cn.edu.zjut.dao.EnterpriseDepartmentImpl;
import cn.edu.zjut.po.ElectronicContracts;

import java.util.List;

public class ElectronicContractsService {
    ElectronicContractsImpl electronicContractsimpl;

    public ElectronicContractsImpl getElectronicContractsimpl() {
        return electronicContractsimpl;
    }

    public void setElectronicContractsimpl(ElectronicContractsImpl electronicContractsimpl) {
        this.electronicContractsimpl = electronicContractsimpl;
    }

    public List queryElectronicContracts() {
        return electronicContractsimpl.queryElectronicContracts();
    }

    public void  addElectronicContracts(ElectronicContracts electronicContracts) {
        electronicContractsimpl.addElectronicContracts(electronicContracts);
    }
}
