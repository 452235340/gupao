package com.wuqingbo.spring.demo.controller;



import com.wuqingbo.spring.demo.service.IDemoService;
import com.wuqingbo.spring.demo.service.IModifyService;
import com.wuqingbo.spring.framework.annotation.QBAutowired;
import com.wuqingbo.spring.framework.annotation.QBController;
import com.wuqingbo.spring.framework.annotation.QBRequestMapping;
import com.wuqingbo.spring.framework.annotation.QBRequestParameter;
import com.wuqingbo.spring.framework.webmvc.servlet.QBModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingbowu on 2019/3/26.
 */
@QBController
@QBRequestMapping("/demo")
public class DemoController {

    @QBAutowired
    private IDemoService demoService;
    @QBAutowired
    private IModifyService modifyService;

    @QBRequestMapping("/query")
    public QBModelAndView queryName(HttpServletRequest request, @QBRequestParameter("name")String name){
        String name1 = demoService.queryName(name);
        return null;
    }

    @QBRequestMapping("/add")
    public QBModelAndView add(HttpServletRequest request, HttpServletResponse response, @QBRequestParameter("name") String name, @QBRequestParameter("addr") String addr){
        try {
            String result = modifyService.add(name, addr);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String,Object> model = new HashMap<String,Object>();
            model.put("detail",e.getMessage());
            model.put("stackTrace",e.getMessage());
            return new QBModelAndView("500",model);
        }
    }

    @QBRequestMapping("/sub")
    public String sub(HttpServletRequest request, HttpServletResponse response, @QBRequestParameter("a") Integer a, @QBRequestParameter("b") Integer b){
        return (a + " - " + b + " = " + ( a - b ));
    }


}
