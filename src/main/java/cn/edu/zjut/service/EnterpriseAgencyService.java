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

    public boolean login(EnterpriseAgency enterpriseAgency) {
        List<EnterpriseAgency> agencyList = enterpriseAgencyImpl.getAllEnterpriseAgency();
        for (EnterpriseAgency agency : agencyList) {
            if (agency.getEnterpriseAgencyAccount().equals(enterpriseAgency.getEnterpriseAgencyAccount()) && agency.getEnterpriseAgencyPassword().equals(enterpriseAgency.getEnterpriseAgencyPassword())) {
                return true;
            }
        }
        return false;
    }
}
