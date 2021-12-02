package cn.edu.zjut.po;

import java.io.Serializable;
import java.util.Date;

public class Advertisement implements Serializable {
    private int advertisementId;
    private String advertisementUrl;
    private String advertisementPictureUrl;
    private Date beginTime;
    private Date endTime;

    @Override
    public String toString() {
        return "Advertisement{" +
                "advertisementId=" + advertisementId +
                ", advertisementUrl='" + advertisementUrl + '\'' +
                ", advertisementPictureUrl='" + advertisementPictureUrl + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }

    public Advertisement() {
    }

    public Advertisement(int advertisementId, String advertisementUrl, String advertisementPictureUrl, Date beginTime, Date endTime) {
        this.advertisementId = advertisementId;
        this.advertisementUrl = advertisementUrl;
        this.advertisementPictureUrl = advertisementPictureUrl;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public int getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(int advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdvertisementUrl() {
        return advertisementUrl;
    }

    public void setAdvertisementUrl(String advertisementUrl) {
        this.advertisementUrl = advertisementUrl;
    }

    public String getAdvertisementPictureUrl() {
        return advertisementPictureUrl;
    }

    public void setAdvertisementPictureUrl(String advertisementPictureUrl) {
        this.advertisementPictureUrl = advertisementPictureUrl;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
