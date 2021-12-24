package cn.edu.zjut.po;

import java.io.Serializable;

public class EnterpriseDepartmentDisplay implements Serializable {
    private String enterpriseDepartmentName;
    private int enterpriseDepartmentId;
    private String faDepartment;
    private int enterpriseId;
    private int enterpriseDepartmentpre;

    public int getEnterpriseDepartmentpre() {
        return enterpriseDepartmentpre;
    }

    public void setEnterpriseDepartmentpre(int enterpriseDepartmentpre) {
        this.enterpriseDepartmentpre = enterpriseDepartmentpre;
    }

    public int getEnterpriseDepartmentId() {
        return enterpriseDepartmentId;
    }

    public void setFaDepartment(String faDepartment) {
        this.faDepartment = faDepartment;
    }

    public String getFaDepartment() {
        return faDepartment;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public String getEnterpriseDepartmentName() {
        return enterpriseDepartmentName;
    }

    public void setEnterpriseDepartmentId(int enterpriseDepartmentId) {
        this.enterpriseDepartmentId = enterpriseDepartmentId;
    }

    public void setEnterpriseDepartmentName(String enterpriseDepartmentName) {
        this.enterpriseDepartmentName = enterpriseDepartmentName;
    }


    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
