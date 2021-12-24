package cn.edu.zjut.action;

import cn.edu.zjut.po.OrderStatus;
import cn.edu.zjut.service.OrderStatusService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class OrderStatusAction implements SessionAware {
    private Map<String, Object> session;
    private OrderStatusService orderStatusService;
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderStatusService getOrderStatusService() {
        return orderStatusService;
    }

    public void setOrderStatusService(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }


    public String getOrderStatusById(){
       List<OrderStatus> orderStatusList= orderStatusService.getOrderStatusById(orderId);
       System.out.println(orderStatusList.size());
       session.put("orderStatusList",orderStatusList);
       return "success";
    }

}
