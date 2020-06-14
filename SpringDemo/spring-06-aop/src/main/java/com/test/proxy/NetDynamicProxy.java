package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NetDynamicProxy {
    public static void main(String[] args) {
        final RealNet realNet = new RealNet();

        Net instance = (Net) Proxy.newProxyInstance(realNet.getClass().getClassLoader(),
                realNet.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始：开启代理");
                        method.invoke(realNet, args);
                        System.out.println("结束：断开代理");
                        return null;
                    }
                });

        instance.browse();
    }
}
