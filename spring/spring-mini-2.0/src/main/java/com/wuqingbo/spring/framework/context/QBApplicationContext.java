package com.wuqingbo.spring.framework.context;

import com.wuqingbo.spring.framework.beans.QBBeanFactory;
import com.wuqingbo.spring.framework.beans.support.QBDefaultListableBeanFactory;

/**
 * Created by qingbowu.
 */
public class QBApplicationContext extends QBDefaultListableBeanFactory implements QBBeanFactory {


    @Override
    public void refresh() {

    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }
}
