package cn.edu.zjut.action;

import cn.edu.zjut.po.Advertisement;
import cn.edu.zjut.service.AdvertisementService;

import javax.swing.*;
import java.util.List;

public class AdvertisementAction {
    private AdvertisementService advertisementService;
    private List advertisementlist;

    public List getAdvertisementlist() {
        return advertisementlist;
    }

    public void setAdvertisementlist(List advertisementlist) {
        this.advertisementlist = advertisementlist;
    }

    public AdvertisementService getAdvertisementService() {
        return advertisementService;
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public String getAdvertisementList() {
        advertisementlist = advertisementService.getAllAdvertisement();
        return "success";
    }
}
