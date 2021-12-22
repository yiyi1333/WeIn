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
    private OrdersMapper ordersMapper;
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


    public void setConsumerDao(ConsumerMapper consumerDao) {
        this.consumerDao = consumerDao;
    }

    public OrdersMapper getOrdersMapper() {
        return ordersMapper;
    }

    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
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

    //判断库存是不是足够
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
        //传入的都是同一个订单的
        WareHouseAddress wareHouseAddress = wareHouseAddressMapper.selectWareHouseAddressById(goodsService.getGoodsById(goodList.get(0)).getWarehouseId());
        Orders orders = new Orders();
        orders.setOrderStatus("待发货");
        orders.setConsumerId(Integer.toString(customerId));
        orders.setShopId(goodsService.getGoodsById(goodList.get(0)).getShopId());
        orders.setLogisticsSingle(null);
        orders.setOrderPaymentMethod(null);
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
        orders.setActuaLAmountPaid(actualprice);
        orders.setGoodTotalPrices(totprice);
        orders.setDiscountAmount(totprice - actualprice);
        orders.setWarehousePhone(wareHouseAddress.getWarehousePhone());
        orders.setWarehouseDetailedAddress(wareHouseAddress.getWarehouseDetailedAddress());
        orders.setWarehouseName(wareHouseAddress.getWarehouseName());
        orders.setWarehouseProvince(wareHouseAddress.getProvince());
        orders.setWarehouseCity(wareHouseAddress.getCity());
        orders.setWarehouseArea(wareHouseAddress.getDistrict());

        JSONObject adrs = JSONObject.parseObject(address);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));
        orders.setOrderDate(date);
        Time time = new Time(0);
        time.setTime(date.getTime());
        orders.setOrderTime(time);
        orders.setDeliveredPhone(adrs.getString("telNumber"));
        orders.setDeliverProvince(adrs.getString("provinceName"));
        orders.setDeliverCity(adrs.getString("cityName"));
        orders.setDeliveredName(adrs.getString("userName"));
        orders.setDeliverArea(adrs.getString("countyName"));
        orders.setDeliveredDetailedAddress("detailInfo");

        ordersMapper.addOrder(orders);

        //创建订单的时候就把库存减掉
        for (int i = 0; i < goodList.size(); i++) {
            Goods goods = goodsService.getGoodById(goodList.get(i), Integer.toString(customerId));
            goods.setGoodsStock(goods.getGoodsStock() - numList.get(i));
            goodsService.updateGoods(goods);
            OrderGood orderGood = new OrderGood();
            orderGood.setGoodId(goodList.get(i));
            orderGood.setOrderId(orders.getOrderId());
            orderGood.setNum(numList.get(i));
            orderGoodMapper.addOrderGood(orderGood);
        }
        return true;
    }

}
