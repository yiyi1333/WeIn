package cn.edu.zjut.service;

import cn.edu.zjut.dao.EnterpriseAgencyImpl;
import cn.edu.zjut.dao.EnterpriseAgencyMapper;
import cn.edu.zjut.po.EnterpriseAgency;

import java.util.List;
import java.util.Objects;

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
            if (Objects.equals(agency.getEnterpriseAgencyAccount(), enterpriseAgency.getEnterpriseAgencyAccount()) && Objects.equals(agency.getEnterpriseAgencyPassword(), enterpriseAgency.getEnterpriseAgencyPassword())) {
                return agency;
            }
        }
        return null;
    }

    public void addEnterpriseAgency(EnterpriseAgency enterpriseAgency) {
        List<EnterpriseAgency> agencyList = enterpriseAgencyImpl.getAllEnterpriseAgency();
        boolean ok = false;
        for (EnterpriseAgency agency : agencyList) {
            if (Objects.equals(agency.getEnterpriseAgencyAccount(), enterpriseAgency.getEnterpriseAgencyAccount())) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            return;
        }
        enterpriseAgencyImpl.addEnterpriseAgency(enterpriseAgency);
    }
}
