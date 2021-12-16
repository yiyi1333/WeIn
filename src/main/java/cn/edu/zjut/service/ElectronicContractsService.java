package cn.edu.zjut.service;

import cn.edu.zjut.dao.ElectronicContractsImpl;

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
}
