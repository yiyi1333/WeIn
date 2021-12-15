package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.service.EnterpriseAgencyService;

public class EnterpriseAgencyAction {
    private EnterpriseAgencyService enterpriseAgencyService;
    private EnterpriseAgency enterpriseAgency;

    public EnterpriseAgency getEnterpriseAgency() {
        return enterpriseAgency;
    }

    public void setEnterpriseAgency(EnterpriseAgency enterpriseAgency) {
        this.enterpriseAgency = enterpriseAgency;
    }

    public void addEnterpriseAgency() {
        enterpriseAgencyService.addEnterpriseAgency(enterpriseAgency);
    }

    public void setEnterpriseAgencyService(EnterpriseAgencyService enterpriseAgencyService) {
        this.enterpriseAgencyService = enterpriseAgencyService;
    }

    public EnterpriseAgencyService getEnterpriseAgencyService() {
        return enterpriseAgencyService;
    }

}
