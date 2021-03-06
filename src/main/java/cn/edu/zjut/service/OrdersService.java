package cn.edu.zjut.service;


import cn.edu.zjut.dao.*;
import cn.edu.zjut.po.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
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
    private OrderStatusMapper orderStatusMapper;
    private OrderStatusMapper orderStatusDao;

    public OrderStatusMapper getOrderStatusDao() {
        return orderStatusDao;
    }

    public void setOrderStatusDao(OrderStatusMapper orderStatusDao) {
        this.orderStatusDao = orderStatusDao;
    }

    public OrderStatusMapper getOrderStatusMapper() {
        return orderStatusMapper;
    }

    public void setOrderStatusMapper(OrderStatusMapper orderStatusMapper) {
        this.orderStatusMapper = orderStatusMapper;
    }

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

    //???????????????????????????
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
        //?????????????????????????????????
        WareHouseAddress wareHouseAddress = wareHouseAddressMapper.selectWareHouseAddressById(goodsService.getGoodsById(goodList.get(0)).getWarehouseId());
        Orders orders = new Orders();
        orders.setOrderStatus("?????????");
        orders.setOrderPaymentMethod("????????????");
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
        Date date = new Date(System.currentTimeMillis());
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
        orders.setDeliveredDetailedAddress(adrs.getString("detailInfo"));
        orders.setOrderStatus("?????????");

        ordersMapper.addOrder(orders);

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(orders.getOrderId());
        orderStatus.setOrderStatusName("?????????");
        orderStatus.setOrderStatusDate(orders.getOrderDate());
        orderStatus.setOrderStatusTime(orders.getOrderTime());
        orderStatusMapper.addOrderStatus(orderStatus);

        //???????????????????????????????????????
        for (int i = 0; i < goodList.size(); i++) {
            Goods goods = goodsService.getGoodById(goodList.get(i), Integer.toString(customerId));
            goods.setGoodsStock(goods.getGoodsStock() - numList.get(i));
            goodsService.updateGoods(goods);
            OrderGood orderGood = new OrderGood();
            orderGood.setGoodId(goodList.get(i));
            orderGood.setOrderId(orders.getOrderId());
            orderGood.setNum(numList.get(i));
            orderGood.setSinglePieceActualPrice(goods.getGoodsRealPrice());
            orderGoodMapper.addOrderGood(orderGood);
        }
        return true;
    }

    public void addLogisticsSingleList(Orders orders) {
        System.out.println("execute --addLogisticsSingleList()-- method.");
        ordersDao.addLogisticsSingleList(orders);
    }

    public void updateOrder(Orders orders) {
        System.out.println("execute --updateOrder-- method");
        ordersDao.updateOrder(orders);
    }

    public OrderGood selectOrderGood(OrderGood OrderGood) {
        System.out.println("execute --selectOrderGood-- method");
        return orderGoodMapper.selectOrderGood(OrderGood);
    }

    public List<Orders> getAllFundFlow() {
        System.out.println("execute --getAllFundFlow()-- method.");
        return ordersDao.getAllFundFlow();
    }

    public List<Orders> getFundFlowByDate(String date) {
        System.out.println("execute --getFundFlowByDate()-- method.");
        return ordersDao.getFundFlowByDate(date);
    }

    public List<OrderGood> getGoodsById(@Param("orderId") Integer orderId) {
        System.out.println("execute --getGoodsById()-- method.");
        return orderGoodMapper.getGoodsById(orderId);
    }

    //???????????????????????????
    public List<OrderShow> showAllOrder(Integer customerId) {
        List<OrderShow> list = ordersDao.showAllOrder(customerId);
        System.out.println(list);
        return list;
    }

    //???????????????
    public OrderShow showOrderDetail(Integer orderId) {
        OrderShow orderShow = ordersDao.showOrderDetail(orderId);
        System.out.println(orderShow);
        return orderShow;
    }

    //????????????????????????????????????
    public List<OrderShow> showWaitReceiveOrder(Integer customerId) {
        List<OrderShow> list = ordersDao.showStatusOrder(customerId, "?????????");
        System.out.println(list);
        return list;
    }

    //????????????????????????????????????
    public List<OrderShow> showWaitPayOrder(Integer customerId) {
        List<OrderShow> list = ordersDao.showStatusOrder(customerId, "?????????");
        System.out.println(list);
        return list;
    }

    //????????????????????????????????????
    public List<OrderShow> showWaitEvaluateOrder(Integer customerId) {
        List<OrderShow> list = ordersDao.showStatusOrder(customerId, "?????????");
        System.out.println(list);
        return list;
    }
    //??????????????????
    public String confirmReceipt(Integer orderId){
        if(ordersDao.modfiyOrderStatus(orderId, "?????????") != 0){
            Date date = new java.sql.Date(System.currentTimeMillis());
            Time time = new Time(date.getTime());
            orderStatusDao.addOrderStatus1(orderId, date, time, "?????????");
            return "????????????";
        }
        else {
            return "????????????";
        }
    }
}
