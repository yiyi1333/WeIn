package cn.edu.zjut.po;

import java.io.Serializable;

public class Enterprise implements Serializable {
    private int enterpriseId;
    private String enterpriseName;

    public Enterprise() {
    }

    public Enterprise(int enterpriseId, String enterpriseName) {
        this.enterpriseId = enterpriseId;
        this.enterpriseName = enterpriseName;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}
