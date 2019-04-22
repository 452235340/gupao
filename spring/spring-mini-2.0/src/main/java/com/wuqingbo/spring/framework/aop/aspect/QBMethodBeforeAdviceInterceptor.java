package com.wuqingbo.spring.framework.aop.aspect;

import com.wuqingbo.spring.framework.aop.intercept.QBMethodInterceptor;
import com.wuqingbo.spring.framework.aop.intercept.QBMethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by qingbowu.
 */
public class QBMethodBeforeAdviceInterceptor extends QBAbstractAspectAdvice implements QBMethodInterceptor {


    public QBMethodBeforeAdviceInterceptor(Method method, Object aspectTarget) {
        super(method, aspectTarget);
    }

    @Override
    public Object invoke(QBMethodInvocation invocation) throws Throwable {
        return invocation.proceed();
    }
}
