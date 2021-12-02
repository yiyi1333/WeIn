package cn.edu.zjut.po;

public class User {
    private String account;
    private String password;
    private int authority;

    public User() {
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthority() {
        return authority;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
}
