package cn.edu.zjut.po;

public class PlatformAdministrator {
    int adminId;
    String adminAccount;
    String adminPassword;
    String adminName;
    String idCardNumber;

    public PlatformAdministrator(){}

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
