package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.po.EnterpriseUser;

import java.util.List;

public interface EnterpriseDepartmentMapper {
    public List<EnterpriseUser> getAllEnterpriseUser();//获得所有部门及其员工信息
    public void addEnterpriseDepartment(EnterpriseDepartment enterpriseDepartment);//添加企业部门
    public List<EnterpriseDepartment> getAllEnterpriseDepartment();//获得所有部门信息
    public List<EnterpriseDepartment> getEnterpriseDepartmentById(int id);//通过企业编号部门信息

    public EnterpriseDepartment getEnterpriseDepartmentById(int id);

    public List<EnterpriseDepartmentDisplay> getAllEnterpriseDepartmentDisplay(int id);// 获取id公司的部门，上级部门按字符串显示

    public void deleteDepartment(int id);// 根据id删除部门

    public List<EnterpriseDepartment> getSubDepartment(int id);// 查询所有下属部门

    public void updateUserDepartment(@Param("id") int id, @Param("departmentId") int departmentId);// 更新用户部门

    public void deleteConsumer(int id);// 删除用户
}
