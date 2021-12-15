package cn.edu.zjut.action;

import cn.edu.zjut.service.CartService;

import java.util.List;

public class CartAction {
    private List cartList;
    private CartService cartService;
    private String consumerId;
    public List getCartList() {
        return cartList;
    }

    public void setCartList(List cartList) {
        this.cartList = cartList;
    }

    public CartService getCartService() {
        return cartService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public String getCart(){
//        int consumerid = Integer.parseInt(consumerId);
        cartList = cartService.getConsumerCartById(4);
        return "success";
    }

    public String addCart(){
        return "success";
    }
}
