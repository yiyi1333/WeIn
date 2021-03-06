package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseAgency;

import java.util.List;

public interface EnterpriseAgencyMapper {
    public List<EnterpriseAgency> getAllEnterpriseAgency();

    public void addEnterpriseAgency(EnterpriseAgency enterpriseAgency);

    public void deleteEnterpriseagency(int id);

    public EnterpriseAgency getEnterpriseAgencyByAccount(String acount);
}
