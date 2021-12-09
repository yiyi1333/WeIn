package cn.edu.zjut.service;

import cn.edu.zjut.dao.CartMapper;

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
        return cartDao.getConsumerCart(consumerId);
    }
}
