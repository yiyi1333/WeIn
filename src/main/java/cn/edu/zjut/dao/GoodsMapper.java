package cn.edu.zjut.dao;

import cn.edu.zjut.po.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    // 根据商品名模糊查询
    public List searchGoodsByKeyWord(@Param("keyword") String keyword);
    // 根据商品id查询
    public Goods getGoodById(@Param("goodid") Integer goodid);
    // 查询所有商品
    public List<Goods> getAllGoods();
    // 更新商品信息
    public void updateGoods(Goods goods);
    // 添加商品
    public void addGoods(Goods goods);
}
