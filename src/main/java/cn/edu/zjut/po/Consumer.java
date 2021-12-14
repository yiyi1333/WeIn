package cn.edu.zjut.po;

import java.io.Serializable;

public class Consumer implements Serializable {
    private int consumerId;
    private String idCardNumber;
    private String name;
    private String phoneNumber;
    private String password;
    private String email;
    private String avatarUrl;
    private Integer enterpriseDepartmentNumber;

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerId=" + consumerId +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", enterpriseDepartmentNumber=" + enterpriseDepartmentNumber +
                '}';
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getEnterpriseDepartmentNumber() {
        return enterpriseDepartmentNumber;
    }

    public void setEnterpriseDepartmentNumber(Integer enterpriseDepartmentNumber) {
        this.enterpriseDepartmentNumber = enterpriseDepartmentNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Consumer(){}

    public Consumer(int consumerId, String idCardNumber, String name, String phoneNumber, String password, String email, String avatarUrl, Integer enterpriseDepartmentNumber) {
        this.consumerId = consumerId;
        this.idCardNumber = idCardNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.enterpriseDepartmentNumber = enterpriseDepartmentNumber;
    }
}
