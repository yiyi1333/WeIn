package cn.edu.zjut.action;

import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.service.ConsumerService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class ConsumerAction implements SessionAware{
    private ConsumerService consumerService;
    private Map<String, Object> session;
    private Consumer consumer;

    public ConsumerService getConsumerService() {
        return consumerService;
    }

    public void setConsumerService(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String getConsumerList() {
        List<Consumer> consumerlist = consumerService.getAllConsumer();
        session.put("consumerlist",consumerlist);
        return "success";
    }

    public String addConsumer(){
        consumerService.addConsumer(consumer);
        return "success";
    }
}
