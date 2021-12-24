package cn.edu.zjut.service;


import cn.edu.zjut.annotation.MyLog;
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

    @MyLog
    public void addWareHouseAddress(WareHouseAddress wareHouseAddress) {
        System.out.println("execute --addWareHouseAddress()-- method.");
        wareHouseAddressDao.addWareHouseAddress(wareHouseAddress);
    }

    public List<WareHouseAddress> selectWareHouseAddress(WareHouseAddress wareHouseAddress) {
        System.out.println("execute --selectWareHouseAddress()-- method.");
        return wareHouseAddressDao.selectWareHouseAddress(wareHouseAddress);
    }

    @MyLog
    public void deleteWareHouseAddressById(Integer warehouseId) {
        System.out.println("execute --deleteWareHouseAddressById()-- method.");
        wareHouseAddressDao.deleteWareHouseAddressById(warehouseId);
    }

    public WareHouseAddress selectWareHouseAddressById(Integer warehouseId) {
        System.out.println("execute --selectWareHouseAddressById()-- method.");
        return wareHouseAddressDao.selectWareHouseAddressById(warehouseId);
    }

    @MyLog
    public void updateWareHouseAddress(WareHouseAddress wareHouseAddress) {
        System.out.println("execute --updateWareHouseAddress()-- method.");
        wareHouseAddressDao.updateWareHouseAddress(wareHouseAddress);
    }

}
