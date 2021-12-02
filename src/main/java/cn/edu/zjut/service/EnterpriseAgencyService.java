package cn.edu.zjut.service;

import cn.edu.zjut.dao.EnterpriseAgencyImpl;
import cn.edu.zjut.dao.EnterpriseAgencyMapper;
import cn.edu.zjut.po.EnterpriseAgency;

import java.util.List;

public class EnterpriseAgencyService {
    private EnterpriseAgencyImpl enterpriseAgencyImpl;

    public EnterpriseAgencyImpl getEnterpriseAgencyImpl() {
        return enterpriseAgencyImpl;
    }

    public void setEnterpriseAgencyImpl(EnterpriseAgencyImpl enterpriseAgencyImpl) {
        this.enterpriseAgencyImpl = enterpriseAgencyImpl;
    }


    public EnterpriseAgency login(EnterpriseAgency enterpriseAgency) {
        System.out.println("execute --login()-- method.");

        List<EnterpriseAgency> agencyList = enterpriseAgencyImpl.getAllEnterpriseAgency();
        for (EnterpriseAgency agency : agencyList) {
            if (agency.getEnterpriseAgencyAccount().equals(enterpriseAgency.getEnterpriseAgencyAccount()) && agency.getEnterpriseAgencyPassword().equals(enterpriseAgency.getEnterpriseAgencyPassword())) {
                return agency;
            }
        }
        return null;
    }
}
