package com.wuqingbo.spring.framework.context;

import com.wuqingbo.spring.framework.beans.QBBeanFactory;
import com.wuqingbo.spring.framework.beans.QBBeanWrapper;
import com.wuqingbo.spring.framework.beans.config.QBBeanDefinition;
import com.wuqingbo.spring.framework.beans.support.QBBeanDefinitionReader;
import com.wuqingbo.spring.framework.beans.support.QBDefaultListableBeanFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by qingbowu.
 */
public class QBApplicationContext extends QBDefaultListableBeanFactory implements QBBeanFactory {

    private QBBeanDefinitionReader reader;

    private String[] configLocations;

    public QBApplicationContext(String ... configLocations){
        this.configLocations = configLocations;
        try {
            refresh();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    @Override
    public void refresh() throws Exception {
        //1、定位配置文件
        reader = new QBBeanDefinitionReader(configLocations);

        //2、加载配置文件，扫描相关的类，把它们封装成BeanDefinition
        List<QBBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();

        //3、注册，把配置信息放到容器里面(伪IOC容器)
        doRegisterBeanDefinitions(beanDefinitions);

        //4、把非延迟加载的类提前初始化
        doAutoWrited();
    }

    //注入，只处理非延时加载的情况
    private void doAutoWrited() {

        for (Map.Entry<String,QBBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()){
            String benaName = beanDefinitionEntry.getKey();
            if (!beanDefinitionEntry.getValue().isLazyInit()){
                getBean(benaName);
            }
        }

    }


    private void doRegisterBeanDefinitions(List<QBBeanDefinition> beanDefinitions) {
        for (QBBeanDefinition beanDefinition : beanDefinitions){
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
        }
    }


    //依赖注入从这里开始，通过读取BeanDefinition中的信息
    //然后通过反射机制创建一个实例并返回
    //Spring的做法是：不会把最原始的对象返回出去，会用一个BeanWrapper来进行一次包装
    //装饰器模式：
    //1、保留原来的OOP关系
    //2、我们需要对它进行扩展，增强(为了后面AOP做铺垫)
    @Override
    public Object getBean(String beanName) {
        //初始化和注入分为两步操作是因为实例存在循环依赖的问题
        //初始化
        QBBeanWrapper beanWrapper = instantiateBean(beanName, new QBBeanDefinition());

        //注入
        populateBean(beanName,new QBBeanDefinition(),beanWrapper);
        return null;
    }

    private void populateBean(String beanName, QBBeanDefinition qbBeanDefinition, QBBeanWrapper qbBeanWrapper) {

    }

    private QBBeanWrapper instantiateBean(String beanName, QBBeanDefinition beanDefinition) {
        
        return null;
    }
}
