package com.wuqingbo.spring.framework.aop.intercept;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by qingbowu.
 */
public class QBMethodInvocation {


    public QBMethodInvocation(
            Object proxy,  Object target, Method method,  Object[] arguments,
           Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers) {

//        this.proxy = proxy;
//        this.target = target;
//        this.targetClass = targetClass;
//        this.method = BridgeMethodResolver.findBridgedMethod(method);
//        this.arguments = AopProxyUtils.adaptArgumentsIfNecessary(method, arguments);
//        this.interceptorsAndDynamicMethodMatchers = interceptorsAndDynamicMethodMatchers;
    }

    public Object proceed() throws Throwable {
        return null;
    }
}
