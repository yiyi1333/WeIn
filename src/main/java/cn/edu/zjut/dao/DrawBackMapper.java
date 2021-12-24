package cn.edu.zjut.dao;

import cn.edu.zjut.po.DrawBack;
import cn.edu.zjut.po.OrderStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrawBackMapper {

    // 根据orderId查询退款金额
    public List<DrawBack> getDrawBackMoneyById(@Param("orderId") Integer orderId);

    // 根据orderId，goodId查
    public DrawBack getDrawBackById(DrawBack drawBack);

    // 更新
    public void updateDrawBack(DrawBack drawBack);

    // 添加
    public void addDrawBack(DrawBack drawBack);
}

