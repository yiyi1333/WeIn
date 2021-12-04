package cn.edu.zjut.service;

import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.po.Consumer;

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
}
