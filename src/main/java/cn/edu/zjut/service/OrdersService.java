package cn.edu.zjut.service;


import cn.edu.zjut.dao.*;
import cn.edu.zjut.po.*;
import com.alibaba.fastjson.JSONObject;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author hydrogen_zyx
 */
public class OrdersService {
    private OrdersMapper ordersDao;
    private GoodsMapper goodsDao;
    private ConsumerMapper consumerDao;
    private OrderGoodMapper orderGoodMapper;
    private NewOrderMapper newOrderMapper;
    private WareHouseAddressMapper wareHouseAddressMapper;
    private GoodsService goodsService;


    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public WareHouseAddressMapper getWareHouseAddressMapper() {
        return wareHouseAddressMapper;
    }

    public void setWareHouseAddressMapper(WareHouseAddressMapper wareHouseAddressMapper) {
        this.wareHouseAddressMapper = wareHouseAddressMapper;
    }

    public OrderGoodMapper getOrderGoodMapper() {
        return orderGoodMapper;
    }

    public void setOrderGoodMapper(OrderGoodMapper orderGoodMapper) {
        this.orderGoodMapper = orderGoodMapper;
    }

    public ConsumerMapper getConsumerDao() {
        return consumerDao;
    }

    public NewOrderMapper getNewOrderMapper() {
        return newOrderMapper;
    }

    public void setConsumerDao(ConsumerMapper consumerDao) {
        this.consumerDao = consumerDao;
    }

    public void setNewOrderMapper(NewOrderMapper newOrderMapper) {
        this.newOrderMapper = newOrderMapper;
    }

    public GoodsMapper getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsMapper goodsDao) {
        this.goodsDao = goodsDao;
    }

    public OrdersMapper getOrdersDao() {
        return ordersDao;
    }

    public void setOrdersDao(OrdersMapper ordersDao) {
        this.ordersDao = ordersDao;
    }

    public List<Orders> getAllOrders() {
        System.out.println("execute --getAllOrders()-- method.");
        return ordersDao.getAllOrders();
    }

    public List<Orders> selectOrders(Orders orders) {
        System.out.println("execute --selectOrders()-- method.");
        return ordersDao.selectOrders(orders);
    }

    public Orders selectOrderById(Integer orderId) {
        System.out.println("execute --selectOrdersById()-- method.");
        return ordersDao.selectOrdersById(orderId);
    }

    public boolean checkStock(List<Integer> goodList, List<Integer> numList, String address) {
        for (int i = 0; i < goodList.size(); i++) {
            Goods goods = goodsService.getGoodsById(goodList.get(i));
            int num = numList.get(i);
            if (num > goods.getGoodsStock()) {
                return false;
            }
        }
        return true;
    }

    public boolean createOrder(int customerId, List<Integer> goodList, List<Integer> numList, String address) {
        //一个商品一个订单
        //查询用户
        //用于计算折扣价格
        WareHouseAddress wareHouseAddress = wareHouseAddressMapper.selectWareHouseAddressById(goodsService.getGoodsById(goodList.get(0)).getWarehouseId());
        NewOrder newOrder = new NewOrder();
        newOrder.setOrderStatus("待发货");
        newOrder.setConsumerId(Integer.toString(customerId));
        newOrder.setShopId(goodsService.getGoodsById(goodList.get(0)).getShopId());
        newOrder.setLogisticsSingle(null);
        newOrder.setOrderPaymentMethod(null);
        double totprice = 0;
        double actualprice = 0;
        for (int i = 0; i < goodList.size(); i++) {
            Goods goods = goodsService.getGoodById(goodList.get(i), Integer.toString(customerId));
            int num = numList.get(i);
            if (num > goods.getGoodsStock()) {
                return false;
            }
            actualprice += num * goods.getGoodsRealPrice();
            totprice += num * goods.getGoodsPrice();
        }
        newOrder.setActuaLAmountPaid(actualprice);
        newOrder.setGoodTotalPrices(totprice);
        newOrder.setDiscountAmount(totprice - actualprice);
        newOrder.setWarehousePhone(wareHouseAddress.getWarehousePhone());
        newOrder.setWarehouseDetailedAddress(wareHouseAddress.getWarehouseDetailedAddress());
        newOrder.setWarehouseName(wareHouseAddress.getWarehouseName());
        newOrder.setWarehouseProvince(wareHouseAddress.getProvince());
        newOrder.setWarehouseCity(wareHouseAddress.getCity());
        newOrder.setWarehouseArea(wareHouseAddress.getDistrict());

        JSONObject adrs = JSONObject.parseObject(address);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));
        newOrder.setOrderDate(date);
        Time time = new Time(0);
        time.setTime(date.getTime());
        newOrder.setOrderTime(time);
        newOrder.setDeliveredPhone(adrs.getString("telNumber"));
        newOrder.setDeliverProvince(adrs.getString("provinceName"));
        newOrder.setDeliverCity(adrs.getString("cityName"));
        newOrder.setDeliveredName(adrs.getString("userName"));
        newOrder.setDeliverArea(adrs.getString("countyName"));
        newOrder.setDeliveredDetailedAddress("detailInfo");

        newOrderMapper.addOrder(newOrder);

        for (int i = 0; i < goodList.size(); i++) {
            Goods goods = goodsService.getGoodById(goodList.get(i), Integer.toString(customerId));
            goods.setGoodsStock(goods.getGoodsStock() - numList.get(i));
            goodsService.updateGoods(goods);
            OrderGood orderGood = new OrderGood();
            orderGood.setGoodId(goodList.get(i));
            orderGood.setOrderId(newOrder.getOrderId());
            orderGood.setNum(numList.get(i));
            orderGoodMapper.addOrderGood(orderGood);
        }
        return true;
    }

}
