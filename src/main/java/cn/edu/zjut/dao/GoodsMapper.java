package cn.edu.zjut.dao;

import cn.edu.zjut.po.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    // 根据商品名模糊查询
    public List<Goods> searchGoodsByKeyWord(@Param("keyword") String keyword);
    // 根据商品id查询
    public Goods getGoodById(@Param("goodid") Integer goodid);
    // 查询所有商品
    public List<Goods> getAllGoods();
    // 更新商品信息
    public void updateGoods(Goods goods);
    // 添加商品
    public void addGoods(Goods goods);
    // 根据各类要求查看商品
    public List<Goods> selectGoods(Goods goods);
    // 删除商品
    public void deleteGoods(@Param("goodid") Integer goodid);
    //根据发货id查找商品
    public List<Goods> selectGoodsByWarehouseId(@Param("warehouseId") Integer warehouseId);
}
