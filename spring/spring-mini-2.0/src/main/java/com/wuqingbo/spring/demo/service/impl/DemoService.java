package com.wuqingbo.spring.demo.service.impl;

import com.wuqingbo.spring.demo.service.IDemoService;
import com.wuqingbo.spring.framework.annotation.QBService;

/**
 * Created by qingbowu on 2019/3/26.
 */
@QBService
public class DemoService implements IDemoService {
    @Override
    public String queryName(String name) {
        return "my name is " + name;
    }


}
