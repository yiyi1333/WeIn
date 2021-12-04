package cn.edu.zjut.service;



import cn.edu.zjut.dao.WareHouseAddressMapper;
import cn.edu.zjut.po.WareHouseAddress;

import java.util.List;

public class WareHouseAddressService {
    private WareHouseAddressMapper wareHouseAddressDao;

    public WareHouseAddressMapper getWareHouseAddressDao() {
        return wareHouseAddressDao;
    }

    public void setWareHouseAddressDao(WareHouseAddressMapper wareHouseAddressDao) {
        this.wareHouseAddressDao = wareHouseAddressDao;
    }

    public List<WareHouseAddress> getAllWareHouseAddress() {
        System.out.println("execute --getAllWareHouseAddress()-- method.");
        return wareHouseAddressDao.getAllWareHouseAddress();
    }
}
