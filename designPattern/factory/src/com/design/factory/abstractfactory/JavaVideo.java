package com.design.factory.abstractfactory;

/**
 * Created by qingbowu on 2019/3/11.
 */
public class JavaVideo implements IVideo {


    @Override
    public void record() {
        System.out.println("录制Java视频");
    }
}
