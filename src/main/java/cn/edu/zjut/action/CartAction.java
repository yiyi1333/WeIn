package cn.edu.zjut.action;

import cn.edu.zjut.po.Cart;
import cn.edu.zjut.po.CartGoods;
import cn.edu.zjut.po.Goods;
import cn.edu.zjut.service.CartService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CartAction {
    private List cartList;
    private CartService cartService;
    private String consumerId;
    private String goodsId;
    private String message;
    private String shopsList;

    public String getShopsList() {
        return shopsList;
    }

    public void setShopsList(String shopsList) {
        this.shopsList = shopsList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

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
        cartList = cartService.getConsumerCartById(Integer.parseInt(consumerId));
        return "success";
    }
// 加入购物车
    public String addCart(){
        int res = cartService.addToCart(Integer.parseInt(consumerId), Integer.parseInt(goodsId));
        if(res == 0){
            System.out.println("加入购物车异常");
            message = "加入购物车异常";
            return "fail";
        }
        else{
            cartList = cartService.getConsumerCartById(Integer.parseInt(consumerId));
            return "success";
        }
    }
    //更新购物车
    public String updateCart(){
        JSONArray jsonArray = JSONArray.parseArray(shopsList);
        ArrayList<CartGoods> list = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject object = jsonArray.getJSONObject(i);
            JSONArray goodslist = object.getJSONArray("goodslist");
            for(int j = 0; j < goodslist.size(); j++){
                JSONObject temp = goodslist.getJSONObject(j);
                CartGoods g = temp.toJavaObject(CartGoods.class);
                list.add(g);
            }
        }
        cartService.updateCart(list, Integer.parseInt(consumerId));
        return "success";
    }
}
