package com.gupao.vip.pattern.adapter.loginadapter.v2.adapters;

import com.gupao.vip.pattern.adapter.loginadapter.ResultMsg;

/**
 * Created by qingbowu on 2019/3/19.
 */
public class LoginForSinaAdapter implements LoginAdapter {

    @Override
    public boolean isSupport(Object adapter) {
        return adapter instanceof LoginForSinaAdapter;
    }

    @Override
    public ResultMsg login(String key, Object adapter) {
        return null;
    }
}
