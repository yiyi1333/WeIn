package cn.edu.zjut.action;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;
import org.apache.struts2.interceptor.SessionAware;
import cn.edu.zjut.po.SafeGuardingRights;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SafeGuardingRightsAction implements SessionAware {
    private String goodsId;
    private String goodsNum;
    private String descript;
    private String imagePath;
    private String consumerId;
    private String orderId;
    private String statusMes;
    private String type;
    private SafeGuardingRightsService safeGuardingRightsService;
    private Map<String, Object> session;
    private OrdersService ordersService;
    private OrderStatusService orderStatusService;
    private GoodsService goodsService;
    private SafeGuardingRightsProgressService safeGuardingRightsProgressService;
    private SafeGuardingRights safeGuardingRights;
    private int safeGuardingRightsId;
    private DrawBackService DrawBackService;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public OrdersService getOrdersService() {
        return ordersService;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public OrderStatusService getOrderStatusService() {
        return orderStatusService;
    }

    public void setOrderStatusService(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public SafeGuardingRightsProgressService getSafeGuardingRightsProgressService() {
        return safeGuardingRightsProgressService;
    }

    public void setSafeGuardingRightsProgressService(SafeGuardingRightsProgressService safeGuardingRightsProgressService) {
        this.safeGuardingRightsProgressService = safeGuardingRightsProgressService;
    }

    public SafeGuardingRights getSafeGuardingRights() {
        return safeGuardingRights;
    }

    public void setSafeGuardingRights(SafeGuardingRights safeGuardingRights) {
        this.safeGuardingRights = safeGuardingRights;
    }

    public int getSafeGuardingRightsId() {
        return safeGuardingRightsId;
    }

    public void setSafeGuardingRightsId(int safeGuardingRightsId) {
        this.safeGuardingRightsId = safeGuardingRightsId;
    }

    public cn.edu.zjut.service.DrawBackService getDrawBackService() {
        return DrawBackService;
    }

    public void setDrawBackService(cn.edu.zjut.service.DrawBackService drawBackService) {
        DrawBackService = drawBackService;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatusMes() {
        return statusMes;
    }

    public void setStatusMes(String statusMes) {
        this.statusMes = statusMes;
    }

    public SafeGuardingRightsService getSafeGuardingRightsService() {
        return safeGuardingRightsService;
    }

    public void setSafeGuardingRightsService(SafeGuardingRightsService safeGuardingRightsService) {
        this.safeGuardingRightsService = safeGuardingRightsService;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    //获得所有的维权
    public String displayShopSafeGuardingRights() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopOrdersFailed";
        }
        int id=0;
        List<SafeGuardingRights> ans = safeGuardingRightsService.getAllsafeGuardingRights();
        List<SafeGuardingRights> safeGuardingRightsList = new ArrayList<>();
        for (SafeGuardingRights safeGuardingRights : ans) {
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
        List<SafeGuardingRights> ans = safeGuardingRightsService.selectsafeGuardingRights(safeGuardingRights);
        List<SafeGuardingRights> safeGuardingRightsList = new ArrayList<>();
        for (SafeGuardingRights safeGuardingRights : ans) {
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
        SafeGuardingRights safeGuardingRights = safeGuardingRightsService.selectsafeGuardingRightsById(safeGuardingRightsId);
        Goods goods = goodsService.getGoodsById(safeGuardingRights.getGoodId());
        Orders orders = ordersService.selectOrderById(safeGuardingRights.getOrderId());
        safeGuardingRights.setGoods(goods);
        safeGuardingRights.setOrders(orders);
        session.put("safeGuardingRights", safeGuardingRights);
        return "displaySuccess";
    }

    //修改维权信息
    public String changeSafeGuardingRightsProgress() {
        SafeGuardingRights safeGuarding = (SafeGuardingRights) session.get("safeGuardingRights");
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        PlatformAdministrator platformAdministrator = (PlatformAdministrator) session.get("platformAdministrator");
        if (shopManager == null && platformAdministrator == null) {
            return "displayFailed";
        }
        //获取当前时间
        long l = System.currentTimeMillis();
        Date d = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = dateFormat.format(d);
        java.sql.Date ss = java.sql.Date.valueOf(dateNowStr);
        Time time = new Time(0);
        time.setTime(d.getTime());
        //修改维权表
        safeGuarding.setSafeGuardingRightsProgress(safeGuardingRights.getSafeGuardingRightsProgress());
        safeGuardingRights.setSafeGuardingRightsId(safeGuarding.getSafeGuardingRightsId());
        safeGuardingRightsService.updatesafeGuardingRights(safeGuardingRights);
        //修改维权进度表
        SafeGuardingRightsProgress safeGuardingRightsProgress = new SafeGuardingRightsProgress();
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
        if (safeGuardingRights.getSafeGuardingRightsProgress().equals("仅退款") || safeGuardingRights.getSafeGuardingRightsProgress().equals("退款退货")) {
            DrawBack drawBack = new DrawBack();
            drawBack.setOrderId(safeGuarding.getOrderId());
            drawBack.setGoodsId(safeGuarding.getGoodId());
            drawBack.setType(safeGuarding.getSafeGuardingRightsProgress());
            //获得总共退款金额
            OrderGood orderGood = new OrderGood();
            orderGood.setGoodId(safeGuarding.getGoodId());
            orderGood.setOrderId(safeGuarding.getOrderId());
            orderGood = ordersService.selectOrderGood(orderGood);
            drawBack.setMoney(orderGood.getSinglePieceActualPrice() * safeGuarding.getSafeGuardingRightsNum());
            System.out.println(drawBack.getMoney());
            if (drawBack.getType().equals("仅退款")) {
                drawBack.setGoodsNum(0);
            } else if (drawBack.getType().equals("退货退款")) {
                drawBack.setGoodsNum(safeGuarding.getSafeGuardingRightsNum());
            }
            //判断是否已经存在
            if (DrawBackService.getDrawBackById(drawBack) != null) {
                DrawBackService.updateDrawBack(drawBack);
            } else {
                System.out.println(drawBack);
                DrawBackService.addDrawBack(drawBack);
            }
        }

        SafeGuardingRights safeGuardingRights = safeGuardingRightsService.selectsafeGuardingRightsById(safeGuarding.getSafeGuardingRightsId());
        Goods goods = goodsService.getGoodsById(safeGuardingRights.getGoodId());
        Orders order = ordersService.selectOrderById(safeGuardingRights.getOrderId());
        safeGuardingRights.setGoods(goods);
        safeGuardingRights.setOrders(order);
        session.put("safeGuardingRights", safeGuardingRights);
        if (shopManager != null) {
            return "displaySuccess";
        } else {
            return "displaySuccess2";
        }
    }


    public String applyForRights() {
        System.out.println("goodsId: " + goodsId);
        System.out.println("goodsNum: " + goodsNum);
        System.out.println("descript: " + descript);
        System.out.println("imagePath: " + imagePath);
        System.out.println("consumerId: " + consumerId);
        System.out.println("orderId: " + orderId);
        statusMes = safeGuardingRightsService.applyForRights(Integer.parseInt(goodsId), Integer.parseInt(goodsNum), descript, imagePath, Integer.parseInt(orderId), Integer.parseInt(consumerId), type);
        return "success";
    }

    public String platformInterventionRights() {
        if (safeGuardingRights == null) safeGuardingRights = new SafeGuardingRights();
        safeGuardingRights.setSafeGuardingRightsProgress("平台处理中");
        List<SafeGuardingRights> sgrlist = safeGuardingRightsService.selectsafeGuardingRightsByZyx(safeGuardingRights);
        session.put("sgrlist", sgrlist);

        return "success";
    }

    public String platformInterventionRightsDetails() {
        List<SafeGuardingRights> sgrlist = (List<SafeGuardingRights>) session.get("sgrlist");
        for (SafeGuardingRights guardingRights : sgrlist) {
            if (guardingRights.getSafeGuardingRightsId() == safeGuardingRightsId) {
                session.put("safeGuardingRights", guardingRights);
            }
        }
        return "success";
    }
}
