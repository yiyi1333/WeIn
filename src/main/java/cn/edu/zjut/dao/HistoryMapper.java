package cn.edu.zjut.dao;

import cn.edu.zjut.po.History;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


public interface HistoryMapper {
    public Integer addHistory(@Param("customerId") Integer customerId, @Param("goodsId") Integer goodsId, @Param("date") Date date, @Param("time")Time time);
    public List<History> selectAllHistory(@Param("customerId") Integer customerId);
}
