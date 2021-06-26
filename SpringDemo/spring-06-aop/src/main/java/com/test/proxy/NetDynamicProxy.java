package com.test.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NetDynamicProxy {
    public static void main(String[] argument) {
        final RealNet realNet = new RealNet();

        Net instance = (Net) Proxy.newProxyInstance(realNet.getClass().getClassLoader(),
                realNet.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("开始：开启代理");
                    method.invoke(realNet, args);
                    System.out.println("结束：断开代理");
                    return null;
                });

        instance.browse();
    }
}
