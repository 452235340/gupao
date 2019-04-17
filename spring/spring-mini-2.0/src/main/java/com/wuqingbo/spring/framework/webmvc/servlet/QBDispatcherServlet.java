package com.wuqingbo.spring.framework.webmvc.servlet;

import com.wuqingbo.spring.framework.context.QBApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qingbowu on 2019/4/16.
 */
public class QBDispatcherServlet extends HttpServlet {

    private static final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";

    QBApplicationContext applicationContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、初始化ApplicationContext
        applicationContext = new QBApplicationContext(config.getInitParameter(CONTEXT_CONFIG_LOCATION));
        //2、初始化SpringMVC的九大组件
        initStrategies(applicationContext);
    }

    //初始化策略
    protected void initStrategies(QBApplicationContext context) {
        //多文件上传的组件
        initMultipartResolver(context);
        //初始化本地语言环境
        initLocaleResolver(context);
        //初始化模板处理器
        initThemeResolver(context);
        //handlerMapping
        initHandlerMappings(context);
        //初始化参数适配器
        initHandlerAdapters(context);
        //初始化异常拦截器
        initHandlerExceptionResolvers(context);
        //初始化视图预处理器
        initRequestToViewNameTranslator(context);
        //初始化视图转换器
        initViewResolvers(context);
        //
        initFlashMapManager(context);
    }

    private void initFlashMapManager(QBApplicationContext context) {
    }

    private void initViewResolvers(QBApplicationContext context) {
    }

    private void initRequestToViewNameTranslator(QBApplicationContext context) {
    }

    private void initHandlerExceptionResolvers(QBApplicationContext context) {
    }

    private void initHandlerAdapters(QBApplicationContext context) {
    }

    private void initThemeResolver(QBApplicationContext context) {
    }


    private void initHandlerMappings(QBApplicationContext context) {


    }

    private void initLocaleResolver(QBApplicationContext context) {
    }

    private void initMultipartResolver(QBApplicationContext context) {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
    }


}
