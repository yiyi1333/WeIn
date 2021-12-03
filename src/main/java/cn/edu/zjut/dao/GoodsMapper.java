package cn.edu.zjut.dao;

import cn.edu.zjut.po.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    public List searchGoodsByKeyWord(@Param("keyword") String keyword);

    public List<Goods> getAllGoods();

    public void updateGoods(Goods goods);

    public Goods getGoodsById(int goodsId);
}
