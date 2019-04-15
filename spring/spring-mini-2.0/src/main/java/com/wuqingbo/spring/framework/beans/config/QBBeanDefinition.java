package com.wuqingbo.spring.framework.beans.config;

import lombok.Data;

/**
 * Created by qingbowu on 2019/4/11.
 */
@Data
public class QBBeanDefinition {

    private String beanClassName;
    private boolean lazyInit = false;
    private String factoryBeanName;
}
