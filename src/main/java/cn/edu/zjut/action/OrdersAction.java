package cn.edu.zjut.action;


import cn.edu.zjut.po.Goods;
import cn.edu.zjut.po.Orders;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.service.GoodsService;
import cn.edu.zjut.service.OrdersService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.interceptor.SessionAware;

import java.util.*;

public class OrdersAction implements SessionAware {
    private Map<String, Object> session;
    private OrdersService ordersService;
    private List orderslist;
    private String shops;
    private String address;
    private String consumerId;
    private String createOrderSuccess;
    private GoodsService goodsService;

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
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


    private Orders orders;
    private Integer orderId;

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
        ShopManager shopManager = (ShopManager) session.get("shopManager");
        orders.setShopId(shopManager.getShopId());
        List<Orders> ordersList = ordersService.selectOrders(orders);
        session.put("ordersList", ordersList);
        return "success";
    }

    public String selectWareHouseAddressById() {
        Orders obj = ordersService.selectOrderById(orderId);
        session.put("order", obj);
        return "success";
    }
}
