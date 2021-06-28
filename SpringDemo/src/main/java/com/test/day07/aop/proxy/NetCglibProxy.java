package com.test.day07.aop.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGlib代理类是真实类的子类，通过方法覆写代理父类方法
 */
public class NetCglibProxy {

    private Object target;

    public NetCglibProxy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        //实例化一个增强类
        Enhancer enhancer = new Enhancer();
        //设置增强类的父类是真实类
        enhancer.setSuperclass(target.getClass());
        //设置代理
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o 代理类对象
             * @param method    目标方法
             * @param objects   方法参数
             * @param methodProxy   代理对象对方法的引用
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("设置上网代理");
                Object result = method.invoke(target, objects);
                System.out.println("结束代理");
                return result;
            }
        });
        //生成代理类对象
        return enhancer.create();
    }
}

class NetCglibTest {
    public static void main(String[] args) {
        NetCglibProxy netCglibProxy = new NetCglibProxy(new RealNet());
        Net proxy = (Net) netCglibProxy.getProxy();
        proxy.browse();
    }
}