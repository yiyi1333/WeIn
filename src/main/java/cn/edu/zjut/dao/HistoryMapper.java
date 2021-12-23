package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Time;


public interface HistoryMapper {
    public Integer addHistory(@Param("customerId") Integer customerId, @Param("goodsId") Integer goodsId, @Param("date") Date date, @Param("time")Time time);
}
