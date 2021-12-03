package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseUser;

import java.util.List;

public interface EnterpriseDepartmentMapper {
    public List<EnterpriseUser> getAllEnterpriseUser();//获得所有部门及其员工信息
}
