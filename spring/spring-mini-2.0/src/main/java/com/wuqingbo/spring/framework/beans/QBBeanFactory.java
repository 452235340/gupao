package com.wuqingbo.spring.framework.beans;

/**
 * 单例工厂的顶层设计
 * Created by qingbowu.
 */
public interface QBBeanFactory {

    /**
     * 根据beanName从IOC容器中获得一个实例bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
