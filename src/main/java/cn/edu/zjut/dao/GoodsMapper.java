package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    public List searchGoodsByKeyWord(@Param("keyword") String keyword);
}
