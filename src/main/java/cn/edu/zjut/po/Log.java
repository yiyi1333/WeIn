package cn.edu.zjut.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

public class Log {
    private Integer id;

    private String opeMethod;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date opeDate;

    private String opeIp;

    private String name;

    private String type;

    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

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
        return "Log{" + "id=" + id + ", opeMethod='" + opeMethod + '\'' + ", opeDesc='" + '\'' + ", opeDate=" + opeDate + ", opeIp='" + opeIp + '\'' + '}';
    }
}

