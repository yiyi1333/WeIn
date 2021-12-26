package cn.edu.zjut.service;

import cn.edu.zjut.annotation.MyLog;
import cn.edu.zjut.dao.CartMapper;
import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.dao.ElectronicContractsMapper;
import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.po.*;

import java.util.*;

public class CartService {
    private CartMapper cartDao;
    private GoodsMapper goodsDao;
    private ConsumerMapper consumerDao;
    private ElectronicContractsMapper electronicContractsDao;

    public ElectronicContractsMapper getElectronicContractsDao() {
        return electronicContractsDao;
    }

    public void setElectronicContractsDao(ElectronicContractsMapper electronicContractsDao) {
        this.electronicContractsDao = electronicContractsDao;
    }

    public ConsumerMapper getConsumerDao() {
        return consumerDao;
    }

    public void setConsumerDao(ConsumerMapper consumerDao) {
        this.consumerDao = consumerDao;
    }

    public GoodsMapper getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsMapper goodsDao) {
        this.goodsDao = goodsDao;
    }

    public CartMapper getCartDao() {
        return cartDao;
    }

    public void setCartDao(CartMapper cartDao) {
        this.cartDao = cartDao;
    }

    public List getConsumerCartById(int consumerId) {
        //查询是否是企业员工
        EnterpriseConsumer enterpriseConsumer = consumerDao.searchEnterpriseConsumerById(consumerId);
        ArrayList<Cart> temp = cartDao.getConsumerCart(consumerId);
        Date date = new Date();
        ArrayList<Cart> cartList = new ArrayList<>();
        if(enterpriseConsumer != null){
            //企业员工
            for(Cart c : temp){
                ArrayList<CartGoods> cartGoodsList = new ArrayList<>();
                for(CartGoods g : c.getGoodsList()){
                    ElectronicContracts electronicContracts = electronicContractsDao.queryElectronicContractsByGoodsIdAndDepartmentId(g.getGoods().getGoodsId(),
                            enterpriseConsumer.getEnterpriseDepartment().getEnterpriseDepartmentId(), date);
                    if(electronicContracts != null){
                        //有折扣
                        Double realPrice = g.getGoods().getGoodsPrice() * electronicContracts.getDiscount();
                        realPrice = (double) Math.round(realPrice * 100) / 100;
                        Goods t = g.getGoods();
                        t.setGoodsRealPrice(realPrice);
                        g.setGoods(t);
//                        System.out.println(g);
                    }
                    cartGoodsList.add(g);
                }
//                System.out.println(cartGoodsList);
                c.setGoodsList(cartGoodsList);
                cartList.add(c);
            }
//            System.out.println(cartList);
            temp = (ArrayList<Cart>) cartList.clone();
        }
        ArrayList<Cart> cart = new ArrayList<>();
        Map<Integer, Cart> mp = new HashMap<>();
        for (Cart t : temp) {
            int shopid = t.getShop().getShopId();
            if (mp.containsKey(shopid)) {
                mp.get(shopid).getGoodsList().add(t.getGoodsList().get(0));
            } else {
                mp.put(shopid, t);
            }
        }
        Set<Integer> key = mp.keySet();
        for (Integer it : key) {
            cart.add(mp.get(it));
        }
        return cart;
    }

    public int addToCart(int consumerId, int goodsId) {
        //查询现有记录
        Integer num = cartDao.getCartNum(consumerId, goodsId);
        if (num == null || num == 0) {
            //无记录
            System.out.println("无记录");
            int line = cartDao.insertCart(consumerId, goodsId);
            return line != 0 ? 1 : 0;
        } else {
            //有记录
            //查询库存
            Goods goods = goodsDao.getGoodById(goodsId);
            if (goods.getGoodsStock() < num + 1) {
                //库存不足
                return 0;
            } else {
                int line = cartDao.addOneToCart(consumerId, goodsId);
                return line != 0 ? 1 : 0;
            }
        }
    }

    public void updateCart(ArrayList<CartGoods> list, Integer consumerId){
        List<CartRecord> cartRecordList = cartDao.getRecordAll(consumerId);
        for(CartRecord cr : cartRecordList){
            //查询该条记录
            boolean flag = false;
            for(CartGoods g : list){
                if(g.getGoods().getGoodsId() == cr.getGoodsId()){
                    if(g.getGoodsNum() != cr.getGoodsNum()){
                        //更新数量
                        cartDao.updateRecord(consumerId, g.getGoods().getGoodsId(), g.getGoodsNum());
                    }
                    flag = true;
                    break;
                }
            }
            if (!flag){
                //删除
                cartDao.removeRecord(consumerId, cr.getGoodsId());
            }
        }
    }
}
