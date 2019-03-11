package com.gupao.vip.dynamicproxy.jdkproxy;

/**
 * Created by qingbowu on 2019/3/11.
 */
public class BuyHouseProxyTest {

    public static void main(String[] args) {
        try {
            Customer customer = new Customer();
            Intermediary intermediary = new Intermediary();

            BuyHouse customerProxy = (BuyHouse)intermediary.getInstance(customer);
            customerProxy.buyHouse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
