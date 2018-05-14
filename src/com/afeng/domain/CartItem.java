package com.afeng.domain;

import java.io.Serializable;

/**
 * 购物车中某一商品的相关信息
 */
public class CartItem implements Serializable{
    private Product product;
    private int count;
    private double subTotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubTotal() {
        return count*product.getShop_price();
    }

    //此方法无需使用到
   /* public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }*/

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", count=" + count +
                ", subTotal=" + subTotal +
                '}';
    }
}
