package cn.edu.zjut.dao;

import cn.edu.zjut.po.Collection;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface CollectionMapper {
    public Integer addCollection(@Param("customerId") Integer customerId, @Param("goodsId") Integer goodsId, @Param("date") Date date, @Param("time") Time time);
    public List<Collection> selectAllCollection(@Param("customerId") Integer customerId);
}
