package com.afeng.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart  implements Serializable {
    //定义一个购物项集合的属性
    private Map<String, CartItem> cartItemMap = new LinkedHashMap<>();
    //获得购物车中货物的总金额
    private double totalAmount=0;
    //提供给页面获取信息所用
    public Map<String, CartItem> getCartItemMap() {
        return cartItemMap;
    }
    //计算货物总金额
    public double getToatalAmount() {
        totalAmount = 0;
        for (Map.Entry<String, CartItem> entry : cartItemMap.entrySet()) {
            CartItem cartItem = entry.getValue();
            totalAmount += cartItem.getSubTotal();
        }
        return totalAmount;
    }


    /**
     * 将商品添加到购物车中
     * @param product 要添加入购物车的商品
     * @param count 添加的商品数量
     */
    public void add2Cart(Product product, Integer count) {
        //判断购物车中是否已经有这种商品
        CartItem cartItem = cartItemMap.get(product.getPid());
        if (cartItem == null) {
            //说明购物车中本来没有这种商品
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCount(count);
            cartItemMap.put(product.getPid(), cartItem);
        }else{
            //说明购物车中本来就已经有了这种商品
            cartItem.setCount(cartItem.getCount()+count);
        }
    }

    /**
     * 从购物车中移除某件商品
     * @param pid 商品的id
     */
    public void removeFromCart(String pid){
        cartItemMap.remove(pid);
    }

    /**
     * 清空购物车
     */
    public void clearCart(){
        cartItemMap.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalAmount=" + getToatalAmount() +
                ", cartItemMap=" + getCartItemMap() +
                '}';
    }
}
