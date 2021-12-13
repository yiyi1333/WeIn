package cn.edu.zjut.service;

import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.po.EnterpriseConsumer;

import java.util.List;

public class ConsumerService {
    private ConsumerMapper consumerdao;
    public ConsumerMapper getconsumerdao() {
        return consumerdao;
    }
    public void setConsumerdao(ConsumerMapper consumerdao) {
        this.consumerdao = consumerdao;
    }

    public List<Consumer> getAllConsumer(){
        List<Consumer> consumerlist = consumerdao.getAllConsumer();
        return consumerlist;
    }

    public void addConsumer(Consumer consumer){
        consumerdao.addConsumer(consumer);
    }

    public EnterpriseConsumer loginAndRegister(String phoneNumber){
        //查询是否已经存在该手机号的用户
        Consumer user = consumerdao.searchUser(phoneNumber);
        EnterpriseConsumer enterpriseConsumer = null;
        if(user != null){
            //已经存在的用户
            System.out.println(user);
            //判断用户是否是企业用户
            if(user.getEnterpriseDepartmentNumber() != null){
                //企业用户
                //查询完整的用户信息
                enterpriseConsumer = consumerdao.searchEnterpriseConsumer(phoneNumber);
            }
            else{
                //普通用户
                enterpriseConsumer = new EnterpriseConsumer();
                enterpriseConsumer.setConsumer(user);
                return enterpriseConsumer;
            }
        }
        else{
            //注册一个普通用户
            Consumer newuser = new Consumer();
            newuser.setPhoneNumber(phoneNumber);
            newuser.setName("用户");
            consumerdao.addConsumer(newuser);
            //将该用户数据返回
            enterpriseConsumer = new EnterpriseConsumer();
            enterpriseConsumer.setConsumer(newuser);
        }
        return enterpriseConsumer;
    }
}
