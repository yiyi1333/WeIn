package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    public List getConsumerCart(@Param("consumerId") int consumerId);
}
