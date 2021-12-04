package cn.edu.zjut.action;


import cn.edu.zjut.po.Orders;
import cn.edu.zjut.po.ShopManager;

import cn.edu.zjut.service.OrdersService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrdersAction implements SessionAware {
    private Map<String, Object> session;
    private OrdersService ordersService;
    private List orderslist;

    public List getOrderslist() {
        return orderslist;
    }

    public OrdersService getOrdersService() {
        return ordersService;
    }

    public void setOrderslist(List orderslist) {
        this.orderslist = orderslist;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }



    public String displayShopOrders() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopOrdersFailed";
        }
        List<Orders> ans = ordersService.getAllOrders();
        List<Orders> ordersList = new ArrayList<>();
        for (Orders orders : ans) {
            if (orders.getShopId() == shopManager.getShopId()) {
                ordersList.add(orders);
            }
        }
        session.put("ordersList", ordersList);
        return "displayShopOrdersSuccess";
    }
}
