package cn.edu.zjut.service;

import cn.edu.zjut.annotation.MyLog;
import cn.edu.zjut.dao.ElectronicContractsImpl;
import cn.edu.zjut.dao.EnterpriseDepartmentImpl;
import cn.edu.zjut.dao.EnterpriseImpl;
import cn.edu.zjut.dao.GoodsImpl;
import cn.edu.zjut.po.ElectronicContracts;

import java.util.List;

public class ElectronicContractsService {
    ElectronicContractsImpl electronicContractsimpl;

    EnterpriseDepartmentImpl enterpriseDepartmentImpl;
    GoodsImpl goodsImpl;
    EnterpriseImpl enterpriseImpl;

    public EnterpriseDepartmentImpl getEnterpriseDepartmentImpl() {
        return enterpriseDepartmentImpl;
    }

    public EnterpriseImpl getEnterpriseImpl() {
        return enterpriseImpl;
    }

    public GoodsImpl getGoodsImpl() {
        return goodsImpl;
    }

    public void setEnterpriseDepartmentImpl(EnterpriseDepartmentImpl enterpriseDepartmentImpl) {
        this.enterpriseDepartmentImpl = enterpriseDepartmentImpl;
    }

    public void setEnterpriseImpl(EnterpriseImpl enterpriseImpl) {
        this.enterpriseImpl = enterpriseImpl;
    }

    public void setGoodsImpl(GoodsImpl goodsImpl) {
        this.goodsImpl = goodsImpl;
    }

    public ElectronicContractsImpl getElectronicContractsimpl() {
        return electronicContractsimpl;
    }

    public void setElectronicContractsimpl(ElectronicContractsImpl electronicContractsimpl) {
        this.electronicContractsimpl = electronicContractsimpl;
    }

    public List queryElectronicContracts() {
        return electronicContractsimpl.queryElectronicContracts();
    }

    @MyLog
    public void addElectronicContracts(ElectronicContracts electronicContracts) {
        electronicContractsimpl.addElectronicContracts(electronicContracts);
    }


    public List queryElectronicContractsByEnterpriseId(int id) {
//        legitimacyCheck();
        return electronicContractsimpl.queryElectronicContractsByEnterpriseId(id);
    }

    public List queryElectronicContractsByshopId(int id) {
//        legitimacyCheck();
        return electronicContractsimpl.queryElectronicContractsByShopId(id);
    }


    // ??????????????????????????????????????????????????????????????????
    public void legitimacyCheck() {
        List<ElectronicContracts> contracts = electronicContractsimpl.queryElectronicContracts();
        for (ElectronicContracts cont : contracts) {
            if (enterpriseDepartmentImpl.getEnterpriseDepartmentById(cont.getEnterpriseDepartmentId()) == null || goodsImpl.getGoodById(cont.getGoodsId()) == null || enterpriseImpl.getEnterpriseById(cont.getEnterpriseId()) == null) {
                electronicContractsimpl.disableContracts(cont.getElectronicContractsId());
            }
        }
    }

    public List showVerifyElectronicContracts(int agencyid) {
        List<ElectronicContracts> contracts = electronicContractsimpl.queryElectronicContractsByEnterpriseAgencyId(agencyid);
        return contracts;
    }

    @MyLog
    public void changeStateElectronicContracts(int agencyid, int electronicContractsid, int state) {
        electronicContractsimpl.changeStateElectronicContracts(agencyid, electronicContractsid, state);
    }

    public void changeStateElectronicContracts2(int shopid, int electronicContractsid, int state) {
        electronicContractsimpl.changeStateElectronicContracts2(shopid, electronicContractsid, state);
    }

//    public void changeStateElectronicContracts2(int agencyid) {
//        electronicContractsimpl.changeStateElectronicContracts2(agencyid);
//    }


    public List showShopElectronicContracts(int shopid) {
        List<ElectronicContracts> contracts = electronicContractsimpl.queryElectronicContractsByShopId(shopid);
        return contracts;
    }


    //????????????
    public List queryElectronicContractsLike(ElectronicContracts electronicContracts) {
        return electronicContractsimpl.queryElectronicContractsLike(electronicContracts);
    }
}
