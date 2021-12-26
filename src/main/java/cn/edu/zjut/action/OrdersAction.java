package cn.edu.zjut.action;


import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.OrderShow;
import cn.edu.zjut.po.Orders;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.service.GoodsService;
import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrdersAction implements SessionAware {
    private Map<String, Object> session;
    private OrdersService ordersService;
    private ShopManagerService shopManagerService;
    private List orderslist;
    private String shops;
    private String address;
    private String consumerId;
    private DrawBackService drawBackService;
    private OrderStatusService orderStatusService;
    private String date;
    private String year;
    private String month;
    private String createOrderSuccess;
    private OrderShow order;
    private String orderid;
    private List<Orders> ordersList;
    private GoodsService goodsService;
    private Orders orders;
    private Integer orderId;
    private String statusMes;

    public String getStatusMes() {
        return statusMes;
    }

    public void setStatusMes(String statusMes) {
        this.statusMes = statusMes;
    }


    public void setShopManagerService(ShopManagerService shopManagerService) {
        this.shopManagerService = shopManagerService;
    }

    public ShopManagerService getShopManagerService() {
        return shopManagerService;
    }

    public OrderShow getOrder() {
        return order;
    }

    public void setOrder(OrderShow order) {
        this.order = order;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public DrawBackService getDrawBackService() {
        return drawBackService;
    }

    public void setDrawBackService(DrawBackService drawBackService) {
        this.drawBackService = drawBackService;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
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

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public String getCreateOrderSuccess() {
        return createOrderSuccess;
    }

    public void setCreateOrderSuccess(String createOrderSuccess) {
        this.createOrderSuccess = createOrderSuccess;
    }

    public String getShops() {
        return shops;
    }

    public void setShops(String shops) {
        this.shops = shops;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

    public String createShopOrders() {
        System.out.println(consumerId);
        System.out.println(shops);
        System.out.println(address);
        JSONArray jsonArray = JSONArray.parseArray(shops);

        //检查库存
        boolean ok = true;
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONArray goodjson = JSONArray.parseArray(jsonArray.getJSONObject(i).getString("goodslist"));
            List<List<Integer>> goodsList = new ArrayList<>();
            List<List<Integer>> numList = new ArrayList<>();
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = 0; j < goodjson.size(); j++) {
                JSONObject goodobject = JSONObject.parseObject(goodjson.getJSONObject(j).getString("goods"));
                int warehouseId = Integer.parseInt(goodobject.getString("warehouseId"));
                if (mp.get(warehouseId) == null) {
                    mp.put(warehouseId, numList.size());
                    numList.add(new ArrayList<>());
                    goodsList.add(new ArrayList<>());
                }
                int pos = mp.get(warehouseId);
                goodsList.get(pos).add(Integer.parseInt(goodobject.getString("goodsId")));
                numList.get(pos).add(Integer.parseInt(goodjson.getJSONObject(j).getString("goodsnum")));
            }
            for (int j = 0; j < numList.size(); j++) {
                if (!ordersService.checkStock(goodsList.get(j), numList.get(j), address)) {
                    ok = false;
                    break;
                }
            }
        }

        if (!ok) {
            createOrderSuccess = "createOrderFailed";
            return "failed";
        }

        //生成，相同地址的归类一起生成
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.getJSONObject(i).getString("shop"));
            JSONObject shopjson = JSONObject.parseObject(jsonArray.getJSONObject(i).getString("shop"));
            int shopId = Integer.parseInt(shopjson.getString("shopId"));
            JSONArray goodjson = JSONArray.parseArray(jsonArray.getJSONObject(i).getString("goodslist"));
            List<List<Integer>> goodsList = new ArrayList<>();
            List<List<Integer>> numList = new ArrayList<>();
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = 0; j < goodjson.size(); j++) {
                JSONObject goodobject = JSONObject.parseObject(goodjson.getJSONObject(j).getString("goods"));
                int warehouseId = Integer.parseInt(goodobject.getString("warehouseId"));
                if (mp.get(warehouseId) == null) {
                    mp.put(warehouseId, numList.size());
                    numList.add(new ArrayList<>());
                    goodsList.add(new ArrayList<>());
                }
                int pos = mp.get(warehouseId);
                goodsList.get(pos).add(Integer.parseInt(goodobject.getString("goodsId")));
                numList.get(pos).add(Integer.parseInt(goodjson.getJSONObject(j).getString("goodsnum")));
            }
            for (int j = 0; j < numList.size(); j++) {
                ordersService.createOrder(Integer.parseInt(consumerId), goodsList.get(j), numList.get(j), address);
            }
        }

        createOrderSuccess = "createOrderSuccess";
        return "success";
    }

    public String createLegalShopOrders() {
        //这是一些测试数据
//        consumerId = "4";
//        shops = """
//                [
//                    {
//                        "shop": {
//                            "enterprise": null,
//                            "shopDescription": null,
//                            "shopId": 10,
//                            "shopName": "华为比特专卖店"
//                        },
//                        "goodslist": [
//                            {
//                                "goods": {
//                                    "goodsDetails": null,
//                                    "goodsId": 16,
//                                    "goodsImage": "https://img13.360buyimg.com/n7/jfs/t1/220885/31/5968/89111/61a38576E4b4d82d2/bb652689c18ef8aa.jpg",
//                                    "goodsName": "华为笔记本电脑MateBook 13 20/21新款 13英寸超薄本全面屏轻薄商",
//                                    "goodsPrice": 5699,
//                                    "goodsRealPrice": 0,
//                                    "goodsStock": 10,
//                                    "goodsWeight": 0,
//                                    "isGrouding": 0,
//                                    "shop": null,
//                                    "shopId": 10,
//                                    "tags": "电脑、办公",
//                                    "warehouseId": 2
//                                },
//                                "goodsnum": 4,
//                                "checked": true
//                            }
//                        ]
//                    },
//                    {
//                        "shop": {
//                            "enterprise": null,
//                            "shopDescription": null,
//                            "shopId": 11,
//                            "shopName": "华为京东自营官方旗舰店"
//                        },
//                        "goodslist": [
//                            {
//                                "goods": {
//                                    "goodsDetails": null,
//                                    "goodsId": 17,
//                                    "goodsImage": "https://img10.360buyimg.com/n7/jfs/t1/142117/23/25688/101665/617a8ccbE7e72b91b/d78ca0a687a354cb.jpg",
//                                    "goodsName": "华为笔记本电脑 MateBook D 14 2021款 14英寸 11代酷睿 I",
//                                    "goodsPrice": 4999,
//                                    "goodsRealPrice": 0,
//                                    "goodsStock": 10,
//                                    "goodsWeight": 0,
//                                    "isGrouding": 0,
//                                    "shop": null,
//                                    "shopId": 11,
//                                    "tags": "电脑、办公",
//                                    "warehouseId": 3
//                                },
//                                "goodsnum": 2,
//                                "checked": true
//                            },
//                            {
//                                "goods": {
//                                    "goodsDetails": null,
//                                    "goodsId": 18,
//                                    "goodsImage": "https://img14.360buyimg.com/n7/jfs/t1/194675/37/14021/53586/60f7944cEe141f001/89040fffad82661f.jpg",
//                                    "goodsName": "华为笔记本电脑MateBook 14 2021款 14.0英寸 11代酷睿i7 ",
//                                    "goodsPrice": 6999,
//                                    "goodsRealPrice": 0,
//                                    "goodsStock": 10,
//                                    "goodsWeight": 0,
//                                    "isGrouding": 0,
//                                    "shop": null,
//                                    "shopId": 11,
//                                    "tags": "电脑、办公",
//                                    "warehouseId": 3
//                                },
//                                "goodsnum": 3,
//                                "checked": true
//                            }
//                        ]
//                    }
//                ]
//                """;
//        //数据预处理
//        address = """
//                {
//                    "errMsg": "chooseAddress:ok",
//                    "userName": "张三",
//                    "nationalCode": "510000",
//                    "telNumber": "020-81167888",
//                    "postalCode": "510000",
//                    "provinceName": "广东省",
//                    "cityName": "广州市",
//                    "countyName": "海珠区",
//                    "detailInfo": "新港中路397号"
//                }""";
        System.out.println(consumerId);
        System.out.println(shops);
        System.out.println(address);
        JSONArray jsonArray = JSONArray.parseArray(shops);

        HashSet<Integer> unlawfulGoods = new HashSet<>();
        //检查库存
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONArray goodjson = JSONArray.parseArray(jsonArray.getJSONObject(i).getString("goodslist"));
            List<List<Integer>> goodsList = new ArrayList<>();
            List<List<Integer>> numList = new ArrayList<>();
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = 0; j < goodjson.size(); j++) {
                JSONObject goodobject = JSONObject.parseObject(goodjson.getJSONObject(j).getString("goods"));
                int warehouseId = Integer.parseInt(goodobject.getString("warehouseId"));
                if (mp.get(warehouseId) == null) {
                    mp.put(warehouseId, numList.size());
                    numList.add(new ArrayList<>());
                    goodsList.add(new ArrayList<>());
                }
                int pos = mp.get(warehouseId);
                goodsList.get(pos).add(Integer.parseInt(goodobject.getString("goodsId")));
                numList.get(pos).add(Integer.parseInt(goodjson.getJSONObject(j).getString("goodsnum")));
            }
            for (int j = 0; j < numList.size(); j++) {
                for (int k = 0; k < numList.get(j).size(); k++) {
                    Goods goods = goodsService.getGoodsById(goodsList.get(j).get(k));
                    int num = numList.get(j).get(k);
                    if (goods.getGoodsStock() < num) unlawfulGoods.add(goods.getGoodsId());
                }
            }
        }


        //生成，相同地址的归类一起生成
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.getJSONObject(i).getString("shop"));
            JSONObject shopjson = JSONObject.parseObject(jsonArray.getJSONObject(i).getString("shop"));
            int shopId = Integer.parseInt(shopjson.getString("shopId"));
            JSONArray goodjson = JSONArray.parseArray(jsonArray.getJSONObject(i).getString("goodslist"));
            List<List<Integer>> goodsList = new ArrayList<>();
            List<List<Integer>> numList = new ArrayList<>();
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = 0; j < goodjson.size(); j++) {
                JSONObject goodobject = JSONObject.parseObject(goodjson.getJSONObject(j).getString("goods"));
                Integer it = Integer.parseInt(goodobject.getString("goodsId"));
                if (unlawfulGoods.contains(it)) continue;
                int warehouseId = Integer.parseInt(goodobject.getString("warehouseId"));
                if (mp.get(warehouseId) == null) {
                    mp.put(warehouseId, numList.size());
                    numList.add(new ArrayList<>());
                    goodsList.add(new ArrayList<>());
                }
                int pos = mp.get(warehouseId);
                goodsList.get(pos).add(Integer.parseInt(goodobject.getString("goodsId")));
                numList.get(pos).add(Integer.parseInt(goodjson.getJSONObject(j).getString("goodsnum")));
            }
            for (int j = 0; j < numList.size(); j++) {
                ordersService.createOrder(Integer.parseInt(consumerId), goodsList.get(j), numList.get(j), address);
            }
        }

        createOrderSuccess = "createOrderSuccess";
        return "success";
    }

    public String selectOrders() {
        Date date = orders.getOrderDate();
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = sdf.format(date);
            java.sql.Date ss = java.sql.Date.valueOf(stringDate);
            orders.setOrderDate(ss);
            System.out.println(ss);
        }
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        orders.setShopId(shopManager.getShopId());
        List<Orders> ordersList = ordersService.selectOrders(orders);
        session.put("ordersList", ordersList);
        System.out.println(ordersList);
        return "success";
    }

    public String selectWareHouseAddressById() {
        Orders obj = ordersService.selectOrderById(orderId);
        session.put("order", obj);
        return "success";
    }

    //查询某个用户的全部订单数据
    public String showAllOrder() {
        orderslist = ordersService.showAllOrder(Integer.parseInt(consumerId));
        System.out.println(orderslist);
        return "success";
    }

    //查询某个订单的详情
    public String showOrderDetail() {
        order = ordersService.showOrderDetail(Integer.parseInt(orderid));
        return "success";
    }

    //查询所有待收货订单
    public String showWaitReceiveOrder() {
        orderslist = ordersService.showWaitReceiveOrder(Integer.parseInt(consumerId));
        return "success";
    }

    //查询所以待付款订单
    public String showWaitPayOrder() {
        orderslist = ordersService.showWaitPayOrder(Integer.parseInt(consumerId));
        return "success";
    }

    //查询所有待评价订单
    public String showWaitEvaluateOrder() {
        orderslist = ordersService.showWaitEvaluateOrder(Integer.parseInt(consumerId));
        return "success";
    }

    // 获得所有待发货订单
    public String getLogisticsSingle() {
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopOrdersFailed";
        }
        List<Orders> ans = ordersService.getAllOrders();
        List<Orders> ordersList = new ArrayList<>();
        for (Orders orders : ans) {
            if (orders.getShopId() == shopManager.getShopId() && orders.getOrderStatus().equals("待发货")) {
                ordersList.add(orders);
            }
        }
        session.put("ordersList", ordersList);
        return "displayShopOrdersSuccess";
    }

    // 按提交表单获得待发货订单
    public String addLogisticsSingle() {
        Date date = orders.getOrderDate();
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = sdf.format(date);
            java.sql.Date ss = java.sql.Date.valueOf(stringDate);
            orders.setOrderDate(ss);
            System.out.println(ss);
        }
        orders.setOrderStatus("待发货");
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        orders.setShopId(shopManager.getShopId());
        List<Orders> ordersList = ordersService.selectOrders(orders);
        session.put("ordersList", ordersList);
        System.out.println(ordersList);
        return "success";
    }

    // 按提交表单填写物流单号
    public String addLogisticsSingleList() {
        // 获取当前时间
        long l = System.currentTimeMillis();
        Date d = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = dateFormat.format(d);
        java.sql.Date ss = java.sql.Date.valueOf(dateNowStr);
        Time time = new Time(0);
        time.setTime(d.getTime());
        OrderStatus orderStatus = new OrderStatus();

        // 修改数据库信息
        for (Orders orders : ordersList) {
            if (orders.getLogisticsSingle().equals("") || orders.getLogisticsSingle() == null || orders.getLogisticsSingle().equals("请输入物流单号")) {
                continue;
            }
            orderStatus.setOrderId(orders.getOrderId());
            orderStatus.setOrderStatusName("待收货");
            orderStatus.setOrderStatusDate(ss);
            orderStatus.setOrderStatusTime(time);
            orderStatusService.addOrderStatus(orderStatus);
            orders.setOrderDate(ss);
            orders.setOrderTime(time);
            ordersService.addLogisticsSingleList(orders);
        }

        //获取修改完后的未发货订单
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        if (shopManager == null) {
            return "displayShopOrdersFailed";
        }
        List<Orders> ans = ordersService.getAllOrders();
        List<Orders> ordersList = new ArrayList<>();
        for (Orders orders : ans) {
            if (orders.getShopId() == shopManager.getShopId() && orders.getOrderStatus().equals("待发货")) {
                ordersList.add(orders);
            }
        }
        session.put("ordersList", ordersList);
        return "displayShopOrdersSuccess";
    }

    public String selectOrderById() {
        Orders obj = ordersService.selectOrderById(orderId);
        List<OrderGood> orderGoods = obj.getOrderGoodList();
        List<Goods> goodsList = new ArrayList<Goods>();
        for (int i = 0; i < orderGoods.size(); i++) {
            Goods goods = new Goods();
            goods = goodsService.getGoodsById(orderGoods.get(i).getGoodId());
            goodsList.add(goods);
        }
        session.put("goodsList", goodsList);
        session.put("orderGoods", orderGoods);
        session.put("order", obj);
        return "success";
    }

    public String getAllFundFlow() {
        List<Orders> ordersList = ordersService.getAllFundFlow();
        List<Double> earningList = new ArrayList<>();
        List<Integer> goodsNumList = new ArrayList<>();
        List<String> endTimeList = new ArrayList<>();
        for (int i = 0; i < ordersList.size(); i++) {
            int goodNum = 0;
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderId(ordersList.get(i).getOrderId());
            List<OrderGood> orderGoodList = ordersService.getGoodsById(ordersList.get(i).getOrderId());
            for (int j = 0; j < orderGoodList.size(); j++) {
                goodNum += orderGoodList.get(j).getNum();
            }
            if (ordersList.get(i).getOrderStatus().equals("已完成")) {
                earningList.add(ordersList.get(i).getActuaLAmountPaid());
                goodsNumList.add(goodNum);
                orderStatus.setOrderStatusName("已完成");
            } else if (ordersList.get(i).getOrderStatus().equals("仅退款") || ordersList.get(i).getOrderStatus().equals("退货退款")) {
                List<DrawBack> drawBackList = drawBackService.getDrawBackMoneyById(ordersList.get(i).getOrderId());
                double drawBack = 0;
                int num = 0;
                for (int j = 0; j < drawBackList.size(); j++) {
                    drawBack += drawBackList.get(j).getMoney();
                    num += drawBackList.get(j).getGoodsNum();
                }
                earningList.add(ordersList.get(i).getActuaLAmountPaid() - drawBack);
                goodsNumList.add(goodNum - num);
                if (ordersList.get(i).getOrderStatus().equals("仅退款")) {
                    orderStatus.setOrderStatusName("仅退款");
                } else {
                    orderStatus.setOrderStatusName("退货退款");
                }
            }
            orderStatus = orderStatusService.getOrderStatus(orderStatus).get(0);
            endTimeList.add(orderStatus.getOrderStatusDate().toInstant().plusSeconds(28800).toString().split("T")[0]+" "+orderStatus.getOrderStatusTime());
        }
        session.put("endTimeList", endTimeList);
        session.put("earningList", earningList);
        session.put("ordersList", ordersList);
        session.put("goodsNumList", goodsNumList);
        return "success";
    }

    public String getFundFlowByDate() {
        System.out.println(year);
        System.out.println(month);
        System.out.println(date);
        List<Orders> ordersList = new ArrayList<>();
        if (year.equals("全部") && date.equals("") && !month.equals("")) {
            ordersList = ordersService.getFundFlowByDate(month);
        } else if (!year.equals("") && !year.equals("全部") && date.equals("") && month.equals("")) {
            ordersList = ordersService.getFundFlowByDate(year);
        } else if (!date.equals("") && year.equals("全部") && month.equals("")) {
            ordersList = ordersService.getFundFlowByDate(date);
        } else {
            ordersList = ordersService.getAllFundFlow();
        }
        List<Double> earningList = new ArrayList<>();
        List<Integer> goodsNumList = new ArrayList<>();
        List<String> endTimeList = new ArrayList<>();
        for (int i = 0; i < ordersList.size(); i++) {
            int goodNum = 0;
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderId(ordersList.get(i).getOrderId());
            List<OrderGood> orderGoodList = ordersService.getGoodsById(ordersList.get(i).getOrderId());
            for (int j = 0; j < orderGoodList.size(); j++) {
                goodNum += orderGoodList.get(j).getNum();
            }
            if (ordersList.get(i).getOrderStatus().equals("已完成")) {
                earningList.add(ordersList.get(i).getActuaLAmountPaid());
                goodsNumList.add(goodNum);
                orderStatus.setOrderStatusName("已完成");
            } else if (ordersList.get(i).getOrderStatus().equals("仅退款") || ordersList.get(i).getOrderStatus().equals("退货退款")) {
                List<DrawBack> drawBackList = drawBackService.getDrawBackMoneyById(ordersList.get(i).getOrderId());
                double drawBack = 0;
                int num = 0;
                for (int j = 0; j < drawBackList.size(); j++) {
                    drawBack += drawBackList.get(j).getMoney();
                    num += drawBackList.get(j).getGoodsNum();
                }
                earningList.add(ordersList.get(i).getActuaLAmountPaid() - drawBack);
                goodsNumList.add(goodNum - num);
                if (ordersList.get(i).getOrderStatus().equals("仅退款")) {
                    orderStatus.setOrderStatusName("仅退款");
                } else {
                    orderStatus.setOrderStatusName("退货退款");
                }
            }
            orderStatus = orderStatusService.getOrderStatus(orderStatus).get(0);
            endTimeList.add(orderStatus.getOrderStatusDate().toInstant().plusSeconds(28800).toString().split("T")[0]+" "+orderStatus.getOrderStatusTime());
        }
        session.put("endTimeList", endTimeList);
        session.put("earningList", earningList);
        session.put("ordersList", ordersList);
        session.put("goodsNumList", goodsNumList);
        return "success";
    }

    public String platformFinancialStatistics() {
        List<Orders> tmp = ordersService.getAllOrders();
        Date today = new Date();
        List<Double> money = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            money.add(0.0);
            number.add(0);
        }
        List<Orders> ordersList = new ArrayList<>();
        double thisyearmoney = 0.0;
        double thismonthmoney = 0.0;
        double thisdaymoney = 0.0;
        int thismonthorder = 0;
        int thisdayorder = 0;
        List<ShopManager> shopManagers = shopManagerService.getShopManagerImpl().getAllShopManager();
        int shopmanagernumber = shopManagers.size();
        Map<Integer, Double> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();
        int y = (year == null ? 0 : Integer.parseInt(year));
        int m = (month == null ? 0 : Integer.parseInt(month));
        int d = (date == null ? 0 : Integer.parseInt(date));
        for (Orders ods : tmp) {


            if ("已完成".equals(ods.getOrderStatus()) || "仅退款".equals(ods.getOrderStatus()) || "退货退款".equals(ods.getOrderStatus()) || "退换货".equals(ods.getOrderStatus())) {
                List<OrderStatus> os = orderStatusService.getOrderStatusById(ods.getOrderId());

                double now = ods.getActuaLAmountPaid();
                for (OrderStatus osos : os) {
                    if (osos.getOrderStatusDate().getTime() > ods.getOrderDate().getTime()) {
                        ods.setOrderDate(osos.getOrderStatusDate());
                    }
                }
                List<OrderGood> og = ordersService.getOrderGoodMapper().getGoodsById(ods.getOrderId());
                for (OrderGood ogog : og) {
                    DrawBack tp = new DrawBack();
                    tp.setOrderId(ods.getOrderId());
                    tp.setGoodsId(ogog.getGoodId());
                    DrawBack db = drawBackService.getDrawBackById(tp);
                    if (db == null) continue;
                    now -= db.getMoney();
                }
                java.util.Date utilDate1 = new java.util.Date(ods.getOrderDate().getTime());
                if ((utilDate1.getYear() + 1900 == y || y == 0) && (utilDate1.getMonth() + 1 == m || m == 0) && (utilDate1.getDate() == d || d == 0)) {
                    if (mp1.get(ods.getShopId()) == null) mp1.put(ods.getShopId(), 0.0);
                    if (mp2.get(ods.getShopId()) == null) mp2.put(ods.getShopId(), 0);
                    mp1.put(ods.getShopId(), mp1.get(ods.getShopId()) + now);
                    mp2.put(ods.getShopId(), mp2.get(ods.getShopId()) + 1);
                }
                if (ods.getOrderDate().getYear() == today.getYear()) {
                    thisyearmoney += now;
                    if (ods.getOrderDate().getMonth() == today.getMonth()) {
                        int day = ods.getOrderDate().getDate();
                        money.set(day - 1, money.get(day - 1) + now);
                        number.set(day - 1, number.get(day - 1) + 1);
                        thismonthmoney += now;
                        thismonthorder += 1;
                        if (ods.getOrderDate().getDate() == today.getDate()) {
                            thisdaymoney += now;
                        }
                    }
                }
            }
        }

        session.put("mp1", mp1);
        session.put("mp2", mp2);
        session.put("money", money);
        session.put("number", number);
        session.put("thisyearmoney", thisyearmoney);
        session.put("thismonthmoney", thismonthmoney);
        session.put("thisdaymoney", thisdaymoney);
        session.put("thismonthorder", thismonthorder);
        session.put("shopmanagernumber", shopmanagernumber);
        session.put("thisdayorder", thisdayorder);
        return "success";
    }
    //用户确认收货请求
    public String confirmReceipt(){
        statusMes = ordersService.confirmReceipt(Integer.parseInt(orderid));
        return "success";
    }


}