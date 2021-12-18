package cn.edu.zjut.action;



import cn.edu.zjut.po.GoodsIdAndNum;
import cn.edu.zjut.po.Orders;
import cn.edu.zjut.po.ShopManager;

import cn.edu.zjut.service.OrdersService;
import com.alibaba.fastjson.JSONArray;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrdersAction implements SessionAware {
    private Map<String, Object> session;
    private OrdersService ordersService;
    private List orderslist;
    private String goodsList;
    private String consumerId;

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String goodsList) {
        this.goodsList = goodsList;
    }

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

    public String createShopOrders(){
        //数据预处理
        System.out.println(consumerId);
        System.out.println(goodsList);
        List<GoodsIdAndNum> list = new ArrayList<>();
        JSONArray jsonArray = JSONArray.parseArray(goodsList);
        for(int i = 0; i < jsonArray.size(); i++){
            GoodsIdAndNum goodsIdAndNum = new GoodsIdAndNum(jsonArray.getJSONObject(i).getString("goodsId"), jsonArray.getJSONObject(i).getString("goodsNum"));
            list.add(goodsIdAndNum);
        }

        return "success";
    }
}
