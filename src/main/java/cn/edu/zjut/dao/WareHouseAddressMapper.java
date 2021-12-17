package cn.edu.zjut.dao;


import cn.edu.zjut.po.Area;
import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.WareHouseAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WareHouseAddressMapper {
    public List<WareHouseAddress> getAllWareHouseAddress();
    public void addWareHouseAddress(WareHouseAddress wareHouseAddress);//添加发货地址
    public List<WareHouseAddress> selectWareHouseAddress(WareHouseAddress wareHouseAddress);
    public void updateWareHouseAddress(WareHouseAddress wareHouseAddress);
    public WareHouseAddress selectWareHouseAddressById(@Param("warehouseId") Integer warehouseId);
    public void deleteWareHouseAddressById(@Param("warehouseId") Integer warehouseId);
    public void deleteWareHouseAddressByIds(String tag);
}
