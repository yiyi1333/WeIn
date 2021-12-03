package cn.edu.zjut.service;

import cn.edu.zjut.dao.EnterpriseDepartmentMapper;
import cn.edu.zjut.po.EnterpriseUser;

import java.util.List;

public class EnterpriseDepartmentService {
    private EnterpriseDepartmentMapper enterpriseDepartmentdao;

    public EnterpriseDepartmentMapper getEnterpriseDepartmentdao() {
        return enterpriseDepartmentdao;
    }

    public void setEnterpriseDepartmentdao(EnterpriseDepartmentMapper enterpriseDepartmentdao) {
        this.enterpriseDepartmentdao = enterpriseDepartmentdao;
    }

    public List<EnterpriseUser> getAllEnterpriseUser(){
        List<EnterpriseUser> enterpriseDepartmentlist = enterpriseDepartmentdao.getAllEnterpriseUser();
        System.out.println(enterpriseDepartmentlist);
        return enterpriseDepartmentlist;
    }
}
