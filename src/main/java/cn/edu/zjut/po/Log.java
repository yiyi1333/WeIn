package cn.edu.zjut.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Log {
    private Integer id;

    private String opeMethod;

    private String opeDesc;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date opeDate;

    private String opeIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpeMethod() {
        return opeMethod;
    }

    public void setOpeMethod(String opeMethod) {
        this.opeMethod = opeMethod == null ? null : opeMethod.trim();
    }

    public String getOpeDesc() {
        return opeDesc;
    }

    public void setOpeDesc(String opeDesc) {
        this.opeDesc = opeDesc == null ? null : opeDesc.trim();
    }

    public Date getOpeDate() {
        return opeDate;
    }

    public void setOpeDate(Date opeDate) {
        this.opeDate = opeDate;
    }

    public String getOpeIp() {
        return opeIp;
    }

    public void setOpeIp(String opeIp) {
        this.opeIp = opeIp == null ? null : opeIp.trim();
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", opeMethod='" + opeMethod + '\'' + ", opeDesc='" + opeDesc + '\'' + ", opeDate=" + opeDate + ", opeIp='" + opeIp + '\'' + '}';
    }
}

