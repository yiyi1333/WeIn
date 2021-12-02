package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.service.EnterpriseAgencyService;

public class EnterpriseAgencyAction {
    private EnterpriseAgency enterpriseAgency;
    private EnterpriseAgencyService enterpriseAgencyService;

    public EnterpriseAgency getEnterpriseAgency() {
        return enterpriseAgency;
    }

    public EnterpriseAgencyService getEnterpriseAgencyService() {
        return enterpriseAgencyService;
    }

    public void setEnterpriseAgency(EnterpriseAgency enterpriseAgency) {
        this.enterpriseAgency = enterpriseAgency;
    }

    public void setEnterpriseAgencyService(EnterpriseAgencyService enterpriseAgencyService) {
        this.enterpriseAgencyService = enterpriseAgencyService;
    }

    public String login() {
        if (enterpriseAgencyService.login(enterpriseAgency)) {
            return "enterpriseAgencyLoginSuccess";
        } else {
            return "enterpriseAgencyLoginFailed";
        }
    }
}
