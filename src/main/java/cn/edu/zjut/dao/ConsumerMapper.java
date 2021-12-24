package cn.edu.zjut.dao;

import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.po.EnterpriseConsumer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsumerMapper {
    public List<Consumer> getAllConsumer();//获得所有员工

    public void addConsumer(Consumer consumer);//添加企业员工

    //按照手机号查询某消费者
    public Consumer searchUser(@Param("phoneNumber") String phoneNumber);

    //按手机号查询某企业消费者
    public EnterpriseConsumer searchEnterpriseConsumer(@Param("phoneNumber") String phoneNumber);

    //按编号查询企业消费者
    public EnterpriseConsumer searchEnterpriseConsumerById(@Param("consumerId") Integer consumerId);

    public void updateWxInfo(@Param("phoneNumber") String phoneNumber, @Param("nickName") String nickName, @Param("avatarUrl") String avatarUrl);

    public Consumer getConsumerById(int id);
    //存储实名信息
    public Integer modfiyCertificationInfo(@Param("consumerId")Integer consumerId, @Param("realName") String realName, @Param("idNumber") String idNumber);
}
