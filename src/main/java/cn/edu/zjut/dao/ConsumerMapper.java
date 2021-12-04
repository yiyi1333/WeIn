package cn.edu.zjut.dao;

import cn.edu.zjut.po.Consumer;

import java.util.List;

public interface ConsumerMapper {
    public List<Consumer> getAllConsumer();//获得所有员工
    public void addConsumer(Consumer consumer);//添加企业员工
}
