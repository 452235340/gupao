package com.gupao.vip.pattern.singlerton.lazy;

/**
 * Created by qingbowu on 2019/3/10.
 */
public class ExcutorThread implements Runnable {

    @Override
    public void run() {
        LazySingleton lazySingleton =LazySingleton.getInstance();
        

        System.out.println(Thread.currentThread().getName()+"-->"+lazySingleton.toString());
    }
}
