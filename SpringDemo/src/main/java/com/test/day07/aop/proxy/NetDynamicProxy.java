package com.test.day07.aop.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class NetDynamicProxy {
    public static void main(String[] argument) {
        RealNet realNet = new RealNet();

        Net instance = (Net) Proxy.newProxyInstance(realNet.getClass().getClassLoader(),
                realNet.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("开始：开启代理");
                    Object result = method.invoke(realNet, args);
                    System.out.println("结束：断开代理");
                    return result;
                });

        instance.browse();
    }
}
