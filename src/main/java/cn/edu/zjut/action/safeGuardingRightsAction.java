package cn.edu.zjut.action;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class safeGuardingRightsAction implements SessionAware{
    private Map<String, Object> session;
    private OrdersService ordersService;
    private OrderStatusService orderStatusService;
    private GoodsService goodsService;
    private safeGuardingRightsService safeGuardingRightsService;
    private safeGuardingRightsProgressService safeGuardingRightsProgressService;
    private safeGuardingRights safeGuardingRights;
    private int safeGuardingRightsId;
    private DrawBackService DrawBackService;

    public cn.edu.zjut.service.DrawBackService getDrawBackService() {
        return DrawBackService;
    }

    public void setDrawBackService(cn.edu.zjut.service.DrawBackService drawBackService) {
        DrawBackService = drawBackService;
    }

    public cn.edu.zjut.service.safeGuardingRightsProgressService getSafeGuardingRightsProgressService() {
        return safeGuardingRightsProgressService;
    }

    public void setSafeGuardingRightsProgressService(cn.edu.zjut.service.safeGuardingRightsProgressService safeGuardingRightsProgressService) {
        this.safeGuardingRightsProgressService = safeGuardingRightsProgressService;
    }

    public int getSafeGuardingRightsId() {
        return safeGuardingRightsId;
    }

    public void setSafeGuardingRightsId(int safeGuardingRightsId) {
        this.safeGuardingRightsId = safeGuardingRightsId;
    }

    public cn.edu.zjut.po.safeGuardingRights getSafeGuardingRights() {
        return safeGuardingRights;
    }

    public void setSafeGuardingRights(cn.edu.zjut.po.safeGuardingRights safeGuardingRights) {
        this.safeGuardingRights = safeGuardingRights;
    }

    public OrderStatusService getOrderStatusService() {
        return orderStatusService;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public OrdersService getOrdersService() {
        return ordersService;
    }

    public cn.edu.zjut.service.safeGuardingRightsService getSafeGuardingRightsService() {
        return safeGuardingRightsService;
    }

    public void setOrderStatusService(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public void setSafeGuardingRightsService(cn.edu.zjut.service.safeGuardingRightsService safeGuardingRightsService) {
        this.safeGuardingRightsService = safeGuardingRightsService;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    //获得所有的维权
    public String displayShopSafeGuardingRights() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopOrdersFailed";
        }
        int id=0;
        List<safeGuardingRights> ans = safeGuardingRightsService.getAllsafeGuardingRights();
        List<safeGuardingRights> safeGuardingRightsList = new ArrayList<>();
        for (safeGuardingRights safeGuardingRights : ans) {
            if(safeGuardingRights.getSafeGuardingRightsId()!=id){
                id = safeGuardingRights.getSafeGuardingRightsId();
            }
            else{
                continue;
            }
            Goods goods = goodsService.getGoodsById(safeGuardingRights.getGoodId());
            Orders orders = ordersService.selectOrderById(safeGuardingRights.getOrderId());
            safeGuardingRights.setGoods(goods);
            safeGuardingRights.setOrders(orders);
            if (safeGuardingRights.getGoods().getShopId() == shopManager.getShopId()) {
                safeGuardingRightsList.add(safeGuardingRights);
            }
        }
        session.put("safeGuardingRightsList", safeGuardingRightsList);
        return "displaySuccess";
    }

    //按照条件获取维权
    public String selecthopSafeGuardingRights() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayFailed";
        }
        int id=0;
        List<safeGuardingRights> ans = safeGuardingRightsService.selectsafeGuardingRights(safeGuardingRights);
        List<safeGuardingRights> safeGuardingRightsList = new ArrayList<>();
        for (safeGuardingRights safeGuardingRights : ans) {
            if(safeGuardingRights.getSafeGuardingRightsId()!=id){
                id = safeGuardingRights.getSafeGuardingRightsId();
            }
            else{
                continue;
            }
            Goods goods = goodsService.getGoodsById(safeGuardingRights.getGoodId());
            Orders orders = ordersService.selectOrderById(safeGuardingRights.getOrderId());
            safeGuardingRights.setGoods(goods);
            safeGuardingRights.setOrders(orders);
            if (safeGuardingRights.getGoods().getShopId() == shopManager.getShopId()) {
                safeGuardingRightsList.add(safeGuardingRights);
            }
        }
        session.put("safeGuardingRightsList", safeGuardingRightsList);
        return "displaySuccess";
    }

    //展示维权详细页面
    public String selecthopSafeGuardingRightsById() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayFailed";
        }
        safeGuardingRights safeGuardingRights = safeGuardingRightsService.selectsafeGuardingRightsById(safeGuardingRightsId);
        Goods goods = goodsService.getGoodsById(safeGuardingRights.getGoodId());
        Orders orders = ordersService.selectOrderById(safeGuardingRights.getOrderId());
        safeGuardingRights.setGoods(goods);
        safeGuardingRights.setOrders(orders);
        session.put("safeGuardingRights", safeGuardingRights);
        return "displaySuccess";
    }

    //修改维权信息
    public String changeSafeGuardingRightsProgress() {
        safeGuardingRights safeGuarding = (safeGuardingRights) session.get("safeGuardingRights");
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayFailed";
        }
        //获取当前时间
        long  l = System.currentTimeMillis();
        Date d = new Date(l);
        SimpleDateFormat dateFormat =  new  SimpleDateFormat( "yyyy-MM-dd" );
        String dateNowStr = dateFormat.format(d);
        java.sql.Date ss = java.sql.Date.valueOf(dateNowStr);
        Time time = new Time(0);
        time.setTime(d.getTime());
        //修改维权表
        safeGuarding.setSafeGuardingRightsProgress(safeGuardingRights.getSafeGuardingRightsProgress());
        safeGuardingRights.setSafeGuardingRightsId(safeGuarding.getSafeGuardingRightsId());
        safeGuardingRightsService.updatesafeGuardingRights(safeGuardingRights);
        //修改维权进度表
        safeGuardingRightsProgress safeGuardingRightsProgress = new safeGuardingRightsProgress();
        safeGuardingRightsProgress.setSafeGuardingRightsId(safeGuarding.getSafeGuardingRightsId());
        safeGuardingRightsProgress.setSafeGuardingRightsProgressDate(ss);
        safeGuardingRightsProgress.setSafeGuardingRightsProgressTime(time);
        safeGuardingRightsProgress.setSafeGuardingRightsProgressStatus(safeGuardingRights.getSafeGuardingRightsProgress());
        safeGuardingRightsProgressService.addsafeGuardingRightsProgress(safeGuardingRightsProgress);
        //修改订单表
        Orders orders = new Orders();
        orders.setOrderDate(ss);
        orders.setOrderTime(time);
        orders.setOrderStatus(safeGuardingRights.getSafeGuardingRightsProgress());
        orders.setOrderId(safeGuarding.getOrderId());
        ordersService.updateOrder(orders);
        // 修改订单进度表
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderStatusTime(time);
        orderStatus.setOrderStatusDate(ss);
        orderStatus.setOrderId(safeGuarding.getOrderId());
        orderStatus.setOrderStatusName(safeGuardingRights.getSafeGuardingRightsProgress());
        orderStatusService.addOrderStatus(orderStatus);
        // 修改退款表
        if(safeGuardingRights.getSafeGuardingRightsProgress().equals("仅退款") || safeGuardingRights.getSafeGuardingRightsProgress().equals("退款退货")){
            DrawBack drawBack = new DrawBack();
            drawBack.setOrderId(safeGuarding.getOrderId());
            drawBack.setGoodsId(safeGuarding.getGoodId());
            drawBack.setType(safeGuarding.getSafeGuardingRightsProgress());
            //获得总共退款金额
            OrderGood orderGood = new OrderGood();
            orderGood.setGoodId(safeGuarding.getGoodId());
            orderGood.setOrderId(safeGuarding.getOrderId());
            orderGood = ordersService.selectOrderGood(orderGood);
            drawBack.setMoney(orderGood.getSinglePieceActualPrice()*safeGuarding.getSafeGuardingRightsNum());
            System.out.println(drawBack.getMoney());
            if(drawBack.getType().equals("仅退款")){
                drawBack.setGoodsNum(0);
            }
            else if(drawBack.getType().equals("退货退款")){
                drawBack.setGoodsNum(safeGuarding.getSafeGuardingRightsNum());
            }
            //判断是否已经存在
            if(DrawBackService.getDrawBackById(drawBack)!=null){
                DrawBackService.updateDrawBack(drawBack);
            }
            else{
                System.out.println(drawBack);
                DrawBackService.addDrawBack(drawBack);
            }
        }

        safeGuardingRights safeGuardingRights = safeGuardingRightsService.selectsafeGuardingRightsById(safeGuarding.getSafeGuardingRightsId());
        Goods goods = goodsService.getGoodsById(safeGuardingRights.getGoodId());
        Orders order = ordersService.selectOrderById(safeGuardingRights.getOrderId());
        safeGuardingRights.setGoods(goods);
        safeGuardingRights.setOrders(order);
        session.put("safeGuardingRights", safeGuardingRights);
        return "displaySuccess";
    }
}
