package cn.edu.zjut.service;

import cn.edu.zjut.dao.EnterpriseImpl;
import cn.edu.zjut.dao.EnterpriseMapper;

public class EnterpriseService {
    private EnterpriseImpl enterpriseImpl;

    public EnterpriseImpl getEnterpriseImpl() {
        return enterpriseImpl;
    }

    public void setEnterpriseImpl(EnterpriseImpl enterpriseImpl) {
        this.enterpriseImpl = enterpriseImpl;
    }
}
