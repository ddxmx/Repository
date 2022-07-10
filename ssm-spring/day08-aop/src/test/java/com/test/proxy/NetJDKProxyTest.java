package com.test.proxy;

import com.test.proxy.base.Net;
import com.test.proxy.base.RealNet;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NetJDKProxyTest {
    /**
     * java动态代理，基于接口的代理
     */
    @Test
    public void jdkProxyTest() {
        Net proxyNet = new NetJDKProxy(new RealNet()).getProxy();
        proxyNet.browse();
    }

    /**
     * java动态代理，基于接口的代理
     */
    @Test
    public void jdkProxyTest2() {
        // 生成一个真实类对象
        Net realNet = new RealNet();

        // 生成代理类对象
        Net proxyNet = (Net) Proxy.newProxyInstance(realNet.getClass().getClassLoader(),
                realNet.getClass().getInterfaces(),
                /*
                    proxy：代理类对象
                    method：真实类执行的方法
                    args：真实类执行方法时的参数
                 */
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("开始：开启代理");
                    // 真实类执行的方法返回值
                    Object result = method.invoke(realNet, args);
                    System.out.println("结束：断开代理");
                    return result;
                });

        // 使用代理类进行操作
        proxyNet.browse();
    }
}