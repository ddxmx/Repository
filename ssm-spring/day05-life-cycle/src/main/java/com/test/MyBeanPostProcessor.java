package com.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Spring容器在init-method前后会调用BeanPostProcessor接口中的postProcessBeforeInitialization和postProcessAfterInitialization方法
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 作⽤： Spring创建完对象，并进⾏注⼊后，可以运⾏Before⽅法进⾏加⼯
     * 获得Spring创建好的对象：通过⽅法的参数
     * 最终通过返回值交给Spring框架
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before init");
        return bean;
    }

    /**
     * 作⽤： Spring执⾏完对象的初始化操作后，可以运⾏After⽅法进⾏加⼯
     * 获得Spring创建好的对象：通过⽅法的参数
     * 最终通过返回值交给Spring框架
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after init");
        return bean;
    }
}
