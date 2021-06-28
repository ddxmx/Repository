package com.test.day07.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 需要被代理的类实现接口，基于接口的代理
 */
public class NetJDKProxy implements InvocationHandler {
    private Net proxy;

    private Net realNet;

    public NetJDKProxy(Net realNet) {
        this.realNet = realNet;
    }

    public Net getProxy() {
        /*
            Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
            参数：
            1、loader，真实类的classLoder
            2、interfaces，真实类实现的接口
            3、InvocationHandler，将代理对象关联到上面的InvocationHandler对象上
            返回值：代理类对象
         */
        Net netProxy = (Net) Proxy.newProxyInstance(realNet.getClass().getClassLoader(), realNet.getClass().getInterfaces(), this);
        proxy = netProxy;
        return netProxy;
    }

    /**
     * @param proxy，代理类对象
     * @param method，接口中的方法
     * @param args，方法的参数
     * @return 返回接口中方法的返回值，不清楚是什么类型，使用Object类型接收
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy == this.proxy);
        System.out.println("设置上网代理...");
        Object result = method.invoke(realNet, args);
        System.out.println("取消上网代理...");
        return result;
    }
}

class NetJDKProxyTest {
    public static void main(String[] args) {
        Net net = new NetJDKProxy(new RealNet()).getProxy();
        net.browse();
    }
}
