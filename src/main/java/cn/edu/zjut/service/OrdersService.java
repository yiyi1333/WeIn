package cn.edu.zjut.service;



import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.dao.OrdersMapper;
import cn.edu.zjut.po.*;

import java.util.List;

public class OrdersService {
    private OrdersMapper ordersDao;
    private GoodsMapper goodsDao;
    private ConsumerMapper consumerDao;
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

    public List<Order> createOrder(Integer customerId, List<GoodsIdAndNum> list){
        //一个商品一个订单
        //查询用户
        EnterpriseConsumer enterpriseConsumer = consumerDao.searchEnterpriseConsumerById(customerId);
        //用于计算折扣价格
        for(GoodsIdAndNum idAndNum : list){
            //先把这个商品的详情查出来
            Goods goods = goodsDao.getGoodById(Integer.parseInt(idAndNum.getGoodsId()));
            //判断库存
            if(goods.getGoodsStock() < Integer.parseInt(idAndNum.getGoodsNum())){
                //库存不足
                continue;
            }
            //库存充足

            //计算出折扣

            //下单


        }
        return null;
    }

}
