package cn.edu.zjut.po;

import java.io.Serializable;

public class EnterpriseUser implements Serializable {
    private String enterpriseDepartmentName;
    private int enterpriseDepartmentId;
    private String name;
    private int consumerId;
    @Override
    public String toString() {
        return "Consumer{" +
                ", enterpriseDepartmentName='" + enterpriseDepartmentName + '\'' +
                ", enterpriseDepartmentId=" + enterpriseDepartmentId +
                ", name='" + name + '\'' +
                ", consumerId=" + consumerId +
                '}';
    }

    public int getEnterpriseDepartmentId() {
        return enterpriseDepartmentId;
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

    public int getConsumerId() {
        return consumerId;
    }

    public String getName() {
        return name;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public void setName(String name) {
        this.name = name;
    }


    public EnterpriseUser(){

    }
    public EnterpriseUser(String enterpriseDepartmentName, int enterpriseDepartmentId, String name, int consumerId){
        this.enterpriseDepartmentName = enterpriseDepartmentName;
        this.enterpriseDepartmentId = enterpriseDepartmentId;
        this.name = name;
        this.consumerId = consumerId;
    }
}
