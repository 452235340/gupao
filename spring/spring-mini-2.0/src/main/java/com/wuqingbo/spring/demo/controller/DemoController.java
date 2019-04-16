package com.wuqingbo.spring.demo.controller;



import com.wuqingbo.spring.demo.service.IDemoService;
import com.wuqingbo.spring.framework.annotation.QBAutowired;
import com.wuqingbo.spring.framework.annotation.QBController;
import com.wuqingbo.spring.framework.annotation.QBRequestMapping;
import com.wuqingbo.spring.framework.annotation.QBRequestParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qingbowu on 2019/3/26.
 */
@QBController
@QBRequestMapping("/demo")
public class DemoController {

    @QBAutowired
    private IDemoService demoService;

    @QBRequestMapping("/query")
    public String queryName(HttpServletRequest request,@QBRequestParameter("name")String name){
        return demoService.queryName(name);
    }

    @QBRequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response, @QBRequestParameter("a") Integer a, @QBRequestParameter("b") Integer b){
        return (a + " + " + b + " = " + ( a + b ));
    }

    @QBRequestMapping("/sub")
    public String sub(HttpServletRequest request, HttpServletResponse response, @QBRequestParameter("a") Integer a, @QBRequestParameter("b") Integer b){
        return (a + " - " + b + " = " + ( a - b ));
    }
}
