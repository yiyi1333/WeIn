package cn.edu.zjut.po;

import java.io.Serializable;

public class EnterpriseDepartment implements Serializable {
    private String enterpriseDepartmentName;
    private int enterpriseDepartmentId;
    private int enterpriseDepartmentpre;
    private int enterpriseId;
    @Override
    public String toString() {
        return "Consumer{" +
                ", enterpriseDepartmentName='" + enterpriseDepartmentName + '\'' +
                ", enterpriseDepartmentId=" + enterpriseDepartmentId +
                ", enterpriseDepartmentpre=" + enterpriseDepartmentpre +
                ", enterpriseId=" + enterpriseId +
                '}';
    }

    public int getEnterpriseDepartmentId() {
        return enterpriseDepartmentId;
    }

    public int getEnterpriseDepartmentpre() {
        return enterpriseDepartmentpre;
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

    public void setEnterpriseDepartmentpre(int enterpriseDepartmentpre) {
        this.enterpriseDepartmentpre = enterpriseDepartmentpre;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
    public EnterpriseDepartment(){}
    public EnterpriseDepartment(String enterpriseDepartmentName, int enterpriseDepartmentId, int enterpriseDepartmentpre,int enterpriseId){
        this.enterpriseDepartmentName = enterpriseDepartmentName;
        this.enterpriseDepartmentId = enterpriseDepartmentId;
        this.enterpriseDepartmentpre = enterpriseDepartmentpre;
        this.enterpriseId = enterpriseId;
    }
}
