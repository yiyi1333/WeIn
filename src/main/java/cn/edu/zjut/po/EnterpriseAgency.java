package cn.edu.zjut.po;

public class EnterpriseAgency {
    private int enterpriseAgencyId;
    private String enterpriseAgencyAccount;
    private String enterpriseAgencyPassword;
    private int enterpriseAgencyRight;
    private String enterpriseAgencyName;
    private String idCardNumber;
    private int enterpriseId;

    public EnterpriseAgency() {
    }

    public void setEnterpriseAgencyAccount(String enterpriseAgencyAccount) {
        this.enterpriseAgencyAccount = enterpriseAgencyAccount;
    }

    public void setEnterpriseAgencyId(int enterpriseAgencyId) {
        this.enterpriseAgencyId = enterpriseAgencyId;
    }

    public void setEnterpriseAgencyName(String enterpriseAgencyName) {
        this.enterpriseAgencyName = enterpriseAgencyName;
    }

    public void setEnterpriseAgencyPassword(String enterpriseAgencyPassword) {
        this.enterpriseAgencyPassword = enterpriseAgencyPassword;
    }

    public void setEnterpriseAgencyRight(int enterpriseAgencyRight) {
        this.enterpriseAgencyRight = enterpriseAgencyRight;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public int getEnterpriseAgencyId() {
        return enterpriseAgencyId;
    }

    public int getEnterpriseAgencyRight() {
        return enterpriseAgencyRight;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public String getEnterpriseAgencyAccount() {
        return enterpriseAgencyAccount;
    }

    public String getEnterpriseAgencyName() {
        return enterpriseAgencyName;
    }

    public String getEnterpriseAgencyPassword() {
        return enterpriseAgencyPassword;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }
}
