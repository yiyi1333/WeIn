package cn.edu.zjut.service;

import cn.edu.zjut.dao.AdvertisementMapper;

import java.util.Date;
import java.util.List;

public class AdvertisementService {
    private AdvertisementMapper advertisementdao;

    public AdvertisementMapper getAdvertisementdao() {
        return advertisementdao;
    }

    public void setAdvertisementdao(AdvertisementMapper advertisementdao) {
        this.advertisementdao = advertisementdao;
    }

    public List getAllAdvertisement(){
//        Date date = new Date();
        List advertisementlist = advertisementdao.getAdvertisement();
        return advertisementlist;
    }
}
