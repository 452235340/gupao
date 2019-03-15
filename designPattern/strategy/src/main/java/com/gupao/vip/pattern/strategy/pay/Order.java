package com.gupao.vip.pattern.strategy.pay;

/**
 * Created by qingbowu on 2019/3/15.
 */
public class Order {

    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }


}
