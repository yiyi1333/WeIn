package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.po.EnterpriseUser;

import java.util.List;

public interface EnterpriseDepartmentMapper {
    public List<EnterpriseUser> getAllEnterpriseUser();//获得所有部门及其员工信息
    public void addEnterpriseDepartment(EnterpriseDepartment enterpriseDepartment);//添加企业部门
    public List<EnterpriseDepartment> getAllEnterpriseDepartment();//获得所有部门信息
    public List<EnterpriseDepartment> getEnterpriseDepartmentById(int id);//通过企业编号部门信息
}
