package cn.edu.zjut.action;

import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.po.EnterpriseConsumer;
import cn.edu.zjut.service.ConsumerService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class ConsumerAction implements SessionAware{
    private ConsumerService consumerService;
    private Map<String, Object> session;
    private Consumer consumer;
    private EnterpriseConsumer enterpriseConsumer;
    private String phoneNumber;

    public EnterpriseConsumer getEnterpriseConsumer() {
        return enterpriseConsumer;
    }

    public void setEnterpriseConsumer(EnterpriseConsumer enterpriseConsumer) {
        this.enterpriseConsumer = enterpriseConsumer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    public String login(){
        System.out.println("PhoneNumber：" + phoneNumber );
        enterpriseConsumer = consumerService.loginAndRegister(phoneNumber);
        return "success";
    }
}
