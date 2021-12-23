package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Time;

public interface CollectionMapper {
    public Integer addCollection(@Param("customerId") Integer customerId, @Param("goodsId") Integer goodsId, @Param("date") Date date, @Param("time") Time time);
}
