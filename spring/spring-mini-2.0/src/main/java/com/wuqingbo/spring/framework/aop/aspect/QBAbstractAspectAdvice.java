package com.wuqingbo.spring.framework.aop.aspect;

import java.lang.reflect.Method;

/**
 * Created by qingbowu on 2019/4/22.
 */
public abstract class QBAbstractAspectAdvice {

    private Method method;
    private Object aspectTarget;

    public QBAbstractAspectAdvice(Method method,Object aspectTarget) {
        this.method = method;
        this.aspectTarget = aspectTarget;
    }
}
