package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    /**
     * 只实例化一次，bean默认是单例的
     * 单例模式在加载xml时就创建了bean
     */
    @Test
    public void singletonScopeTest() {
        /*
            ---------------加载xml配置---------------
            User对象被实例化...
            ---------------获取bean对象---------------
         */
        System.out.println("---------------加载xml配置---------------");
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-singleton.xml");
        System.out.println("---------------获取bean对象---------------");
        User user = ctx.getBean("user", User.class);
        User user2 = ctx.getBean("user", User.class);
        System.out.println(user == user2); // true
    }

    /**
     * 多例模式，每次获取bean时都会进行创建
     */
    @Test
    public void protoTypeScopeTest() {
        /*
            ---------------加载xml配置---------------
            ---------------获取bean对象---------------
            User对象被实例化...
            User对象被实例化...
         */
        System.out.println("---------------加载xml配置---------------");
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-protoType.xml");
        System.out.println("---------------获取bean对象---------------");
        User user = ctx.getBean("user", User.class);
        User user2 = ctx.getBean("user", User.class);
        System.out.println(user == user2); // false
    }

    /**
     * 单例bean的生命周期
     */
    @Test
    public void singletonLifeTest() {
        /*
            User对象被实例化...
            before init
            User的init方法被执行...
            after init
            User的destroy方法被执行...
         */
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-lifecycle-singleton.xml");
        ctx.getBean("user", User.class);
        // 销毁容器
        ctx.close();
    }

    /**
     * 多例bean的生命周期
     * init-method会执行，destroy-method不会执行
     */
    @Test
    public void protoTypeLifeTest() {
        /*
            User对象被实例化...
            before init
            User的init方法被执行...
            after init
            User对象被实例化...
            before init
            User的init方法被执行...
            after init
         */
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-lifecycle-protoType.xml");
        ctx.getBean("user", User.class);
        ctx.getBean("user", User.class);
        // 销毁容器
        ctx.close();
    }


    /**
     * lazy-init让对象在获取时才进行创建
     * 多例模式本身就是获取时才创建，无需设置
     */
    @Test
    public void lazyInitTest() {
        /*
            ---------------加载xml配置---------------
            ---------------获取bean对象---------------
            User对象被实例化...
         */
        System.out.println("---------------加载xml配置---------------");
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-lazyInit.xml");
        System.out.println("---------------获取bean对象---------------");
        ctx.getBean("user", User.class);
    }
}