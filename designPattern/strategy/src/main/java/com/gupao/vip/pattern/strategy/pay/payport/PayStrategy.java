package com.gupao.vip.pattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingbowu on 2019/3/15.
 */
public class PayStrategy {

    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> PAY_STRATEGY_MAP = new HashMap<String,Payment>();

    static {
        PAY_STRATEGY_MAP.put(ALI_PAY,new AliPay());
        PAY_STRATEGY_MAP.put(JD_PAY,new JDPay());
        PAY_STRATEGY_MAP.put(WECHAT_PAY,new WeChatPay());
        PAY_STRATEGY_MAP.put(UNION_PAY,new UnionPay());
    }

    public static Payment getPayStrategy(String payStrategyKey){
        return null;
    }
}
