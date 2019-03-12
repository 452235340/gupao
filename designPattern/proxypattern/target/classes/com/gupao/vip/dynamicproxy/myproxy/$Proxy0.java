package com.gupao.vip.dynamicproxy.myproxy;
import com.gupao.vip.dynamicproxy.jdkproxy.BuyHouse;
import java.lang.reflect.*;
public class $Proxy0 implements com.gupao.vip.dynamicproxy.jdkproxy.BuyHouse{
MyInvocationHandler h;
public $Proxy0(MyInvocationHandler h) {
 this.h = h;
}
public void buyHouse() {
try{
Method m = com.gupao.vip.dynamicproxy.jdkproxy.BuyHouse.class.getMethod("buyHouse",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}
}
}