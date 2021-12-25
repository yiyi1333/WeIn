package cn.edu.zjut.po;

import java.sql.Time;
import java.util.Date;

public class SafeGuardingRightsProgress {
    private int safeGuardingRightsProgressId;
    private String safeGuardingRightsProgressStatus;
    private Time safeGuardingRightsProgressTime;
    private Date safeGuardingRightsProgressDate;
    private int safeGuardingRightsId;

    public int getSafeGuardingRightsId() {
        return safeGuardingRightsId;
    }

    public void setSafeGuardingRightsId(int safeGuardingRightsId) {
        this.safeGuardingRightsId = safeGuardingRightsId;
    }

    public int getSafeGuardingRightsProgressId() {
        return safeGuardingRightsProgressId;
    }

    public Date getSafeGuardingRightsProgressDate() {
        return safeGuardingRightsProgressDate;
    }

    public String getSafeGuardingRightsProgressStatus() {
        return safeGuardingRightsProgressStatus;
    }

    public Time getSafeGuardingRightsProgressTime() {
        return safeGuardingRightsProgressTime;
    }

    public void setSafeGuardingRightsProgressId(int safeGuardingRightsProgressId) {
        this.safeGuardingRightsProgressId = safeGuardingRightsProgressId;
    }

    public void setSafeGuardingRightsProgressDate(Date safeGuardingRightsProgressDate) {
        this.safeGuardingRightsProgressDate = safeGuardingRightsProgressDate;
    }

    public void setSafeGuardingRightsProgressStatus(String safeGuardingRightsProgressStatus) {
        this.safeGuardingRightsProgressStatus = safeGuardingRightsProgressStatus;
    }

    public void setSafeGuardingRightsProgressTime(Time safeGuardingRightsProgressTime) {
        this.safeGuardingRightsProgressTime = safeGuardingRightsProgressTime;
    }
}
