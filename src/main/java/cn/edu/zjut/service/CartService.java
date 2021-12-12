package cn.edu.zjut.service;

import cn.edu.zjut.dao.CartMapper;
import cn.edu.zjut.po.Cart;
import cn.edu.zjut.po.CartGoods;
import cn.edu.zjut.po.Goods;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private CartMapper cartDao;

    public CartMapper getCartDao() {
        return cartDao;
    }

    public void setCartDao(CartMapper cartDao) {
        this.cartDao = cartDao;
    }

    public List getConsumerCartById(int consumerId){
        ArrayList<Cart> temp = cartDao.getConsumerCart(consumerId);
        ArrayList<Cart> cart = new ArrayList<>();
        for(Cart t : temp){
            int shopid = t.getShop().getShopId();
            boolean flag = false;
            for(Cart c : cart){
                if(shopid == c.getShop().getShopId()) {
                    CartGoods cartGoods = t.getGoodsList().get(0);
                    c.getGoodsList().add(cartGoods);
                    flag = true;
                }
            }
            if(!flag){
                cart.add(t);
            }
        }
        return cart;
    }
}
