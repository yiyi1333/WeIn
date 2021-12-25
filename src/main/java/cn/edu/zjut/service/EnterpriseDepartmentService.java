package cn.edu.zjut.service;

import cn.edu.zjut.annotation.MyLog;
import cn.edu.zjut.dao.EnterpriseDepartmentMapper;
import cn.edu.zjut.dao.EnterpriseImpl;
import cn.edu.zjut.po.*;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseDepartmentService {
    private EnterpriseDepartmentMapper enterpriseDepartmentMapper;
    private EnterpriseImpl enterpriseImpl;

    public EnterpriseDepartmentMapper getEnterpriseDepartmentMapper() {
        return enterpriseDepartmentMapper;
    }

    public void setEnterpriseDepartmentMapper(EnterpriseDepartmentMapper enterpriseDepartmentMapper) {
        this.enterpriseDepartmentMapper = enterpriseDepartmentMapper;
    }

    public List<EnterpriseUser> getAllEnterpriseUser() {
        return enterpriseDepartmentMapper.getAllEnterpriseUser();
    }

    @MyLog
    public void addEnterpriseDepartment(EnterpriseDepartment enterpriseDepartment) {
        enterpriseDepartmentMapper.addEnterpriseDepartment(enterpriseDepartment);
    }

    public List<EnterpriseDepartment> getAllEnterpriseDepartment() {
        return enterpriseDepartmentMapper.getAllEnterpriseDepartment();
    }

    public List<EnterpriseDepartmentDisplay> getAllEnterpriseDepartmentDisplay(int id) {
        return enterpriseDepartmentMapper.getAllEnterpriseDepartmentDisplay(id);
    }
    public List<EnterpriseDepartment> getEnterpriseDepartmentByEnterpriseId(int id) {
        return enterpriseDepartmentMapper.getEnterpriseDepartmentByEnterpriseId(id);
    }

    public List<EnterpriseDepartment> displayAddEnterpriseDepartment(EnterpriseAgency enterpriseAgency) {

        List<EnterpriseDepartment> tmp = enterpriseDepartmentMapper.getAllEnterpriseDepartment();
        List<EnterpriseDepartment> departments = new ArrayList<>();
        for (EnterpriseDepartment enterpriseDepartment : tmp) {
            if (enterpriseDepartment.getEnterpriseId() == enterpriseAgency.getEnterpriseId()) {
                departments.add(enterpriseDepartment);
            }
        }
        return departments;
    }

    public EnterpriseImpl getEnterpriseImpl() {
        return enterpriseImpl;
    }

    public void setEnterpriseImpl(EnterpriseImpl enterpriseImpl) {
        this.enterpriseImpl = enterpriseImpl;
    }


    public EnterpriseDepartment getEnterpriseDepartmentById(int id) {
        return enterpriseDepartmentMapper.getEnterpriseDepartmentById(id);
    }

    public Enterprise getEnterpriseById(int id) {
        return enterpriseImpl.getEnterpriseById(id);
    }

    @MyLog
    public boolean deleteDepartment(int id) {
        List<EnterpriseDepartment> departments = enterpriseDepartmentMapper.getSubDepartment(id);
        if (departments.size() != 0) {
            return false;
        }
        enterpriseDepartmentMapper.deleteDepartment(id);
        return true;
    }

    @MyLog
    public String updateUserDepartment(int id, int departmentId) {
        enterpriseDepartmentMapper.updateUserDepartment(id, departmentId);
        return "success";
    }

    @MyLog
    public void deleteConsumer(int id) {
        enterpriseDepartmentMapper.deleteConsumer(id);
    }

    //更新部门
    public void updateEnterpriseDapartment(EnterpriseDepartment enterpriseDepartment){
        enterpriseDepartmentMapper.updateEnterpriseDapartment(enterpriseDepartment);
    }

    //模糊查询
    public List<EnterpriseDepartmentDisplay> getEnterpriseDepartmentLike(EnterpriseDepartment enterpriseDepartment) {
        return enterpriseDepartmentMapper.getEnterpriseDepartmentLike(enterpriseDepartment);
    }

    //通过部门id查找名字（用来显示父部门
    public String queryDepartNameByEnterpriseDepartmentId(int EnterpriseDepartmentId) {
        return enterpriseDepartmentMapper.queryDepartNameByEnterpriseDepartmentId(EnterpriseDepartmentId);
    }

}
