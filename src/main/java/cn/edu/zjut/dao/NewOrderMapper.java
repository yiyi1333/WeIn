package cn.edu.zjut.dao;

import cn.edu.zjut.po.NewOrder;

public interface NewOrderMapper {
    /**
     * 插入数据库并返回主键id
     */
    public Integer addOrder(NewOrder newOrder);
}
