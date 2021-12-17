package cn.edu.zjut.action;

import cn.edu.zjut.po.ElectronicContracts;
import cn.edu.zjut.service.ElectronicContractsService;
import cn.edu.zjut.service.RegisterShopmanagerAndEnterpriseagencyService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ElectronicContractsAction implements SessionAware {
    private ElectronicContractsService electronicContractsService;
    private ElectronicContracts electronicContracts;
    private List electronicContractsList;
    private Map<String, Object> session;
    private String enterpriseId;
    //获得企业结构用
    private RegisterShopmanagerAndEnterpriseagencyService registerShopmanagerAndEnterpriseagencyService;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    //商家查看合同内容
    public String queryElectronicContracts() {
        electronicContractsList = electronicContractsService.queryElectronicContracts();
        return "success";
    }

    //编辑合同--获得企业结构
    public String getEnterpriseDepartmentById() {
        electronicContractsList = registerShopmanagerAndEnterpriseagencyService.queryEnterpriseStructure((Integer) session.get("loginuserEnterpriseId"));
        return "success";
    }

    //企业管理员起草合同
    public String editElectronicContracts() {
        Iterator<ElectronicContracts> electronicContractsIterator = electronicContractsList.iterator();
        while (electronicContractsIterator.hasNext()) {
            ElectronicContracts electronicContracts1 = electronicContractsIterator.next();
            electronicContracts1.setState(0);
            electronicContracts1.setEnterpriseId((Integer) session.get("loginuserEnterpriseId"));
            electronicContracts1.setEnterpriseAgencyId(electronicContracts.getEnterpriseAgencyId());
            electronicContracts1.setStarttime(electronicContracts.getStarttime());
            electronicContracts1.setEndtime(electronicContracts.getEndtime());
            electronicContracts1.setGoodsId(electronicContracts.getGoodsId());
            electronicContracts1.setShopId(electronicContracts.getShopId());
            electronicContractsService.addElectronicContracts(electronicContracts1);
        }
        return "success";
    }

    public ElectronicContracts getElectronicContracts() {
        return electronicContracts;
    }

    public void setElectronicContracts(ElectronicContracts electronicContracts) {
        this.electronicContracts = electronicContracts;
    }

    public void setElectronicContractsService(ElectronicContractsService electronicContractsService) {
        this.electronicContractsService = electronicContractsService;
    }

    public ElectronicContractsService getElectronicContractsService() {
        return electronicContractsService;
    }

    public List getElectronicContractsList() {
        return electronicContractsList;
    }

    public void setElectronicContractsList(List electronicContractsList) {
        this.electronicContractsList = electronicContractsList;
    }

    public void setRegisterShopmanagerAndEnterpriseagencyService(RegisterShopmanagerAndEnterpriseagencyService registerShopmanagerAndEnterpriseagencyService) {
        this.registerShopmanagerAndEnterpriseagencyService = registerShopmanagerAndEnterpriseagencyService;
    }

    public RegisterShopmanagerAndEnterpriseagencyService getRegisterShopmanagerAndEnterpriseagencyService() {
        return registerShopmanagerAndEnterpriseagencyService;
    }

    // 企业管理员查看企业的所有合同
    public String queryElectronicContractsByEnterpriseId() {
        Integer id = (Integer) session.get("loginuserEnterpriseId");
        List list = electronicContractsService.queryElectronicContractsByEnterpriseId(id);
        session.put("contracts", list);
        return "success";
    }
}


