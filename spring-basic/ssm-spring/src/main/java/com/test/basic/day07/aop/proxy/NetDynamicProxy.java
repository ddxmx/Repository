package com.test.basic.day07.aop.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 基于真实类父接口的代理
 */
public class NetDynamicProxy {
    public static void main(String[] argument) {
        //生成一个真实类对象
        RealNet realNet = new RealNet();

        Net instance = (Net) Proxy.newProxyInstance(realNet.getClass().getClassLoader(),
                realNet.getClass().getInterfaces(),
                /*
                    proxy：代理类对象
                    method：真实类执行的方法
                    args：真实类执行方法时的参数
                 */
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("开始：开启代理");
                    //真实类执行的方法返回值
                    Object result = method.invoke(realNet, args);
                    System.out.println("结束：断开代理");
                    return result;
                });

        //使用代理类进行操作
        instance.browse();
    }
}
