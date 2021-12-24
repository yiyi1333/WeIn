package cn.edu.zjut.service;

import cn.edu.zjut.annotation.MyLog;
import cn.edu.zjut.dao.CartMapper;
import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.po.Cart;
import cn.edu.zjut.po.CartGoods;
import cn.edu.zjut.po.Goods;

import java.util.*;

public class CartService {
    private CartMapper cartDao;
    private GoodsMapper goodsDao;

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
        ArrayList<Cart> temp = cartDao.getConsumerCart(consumerId);
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

    @MyLog
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
}
