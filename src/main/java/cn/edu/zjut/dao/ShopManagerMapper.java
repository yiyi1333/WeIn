package cn.edu.zjut.dao;
import cn.edu.zjut.po.ShopManager;

import java.util.List;

public interface ShopManagerMapper {
    public List<ShopManager> getAllShopManager();
    public void addShopManager(ShopManager shopManager);
}
