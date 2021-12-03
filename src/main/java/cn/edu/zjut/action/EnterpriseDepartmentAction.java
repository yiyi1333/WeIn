package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseUser;
import cn.edu.zjut.service.EnterpriseDepartmentService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnterpriseDepartmentAction implements SessionAware{
    private EnterpriseDepartmentService enterpriseUserService;
    private EnterpriseUser enterpriseUser;
    private Map<String, Object> session;

    public EnterpriseDepartmentService getEnterpriseUserService() {
        return enterpriseUserService;
    }

    public void setEnterpriseUserService(EnterpriseDepartmentService enterpriseUserService) {
        this.enterpriseUserService = enterpriseUserService;
    }

    public void setEnterpriseUser(EnterpriseUser enterpriseUser) {
        this.enterpriseUser = enterpriseUser;
    }

    public EnterpriseUser getEnterpriseUser() {
        return enterpriseUser;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String getEnterpriseList() {
        List<EnterpriseUser> enterpriseUserlist = enterpriseUserService.getAllEnterpriseUser();
        session.put("enterpriseUserlist",enterpriseUserlist);
        return "success";
    }
}
