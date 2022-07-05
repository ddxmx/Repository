package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    /**
     * 只实例化一次，bean默认是单例的
     */
    @Test
    public void defaultScopeTypeTest() {
        System.out.println("---------------加载xml配置---------------");
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-singleton.xml");
        System.out.println("---------------获取bean对象---------------");
        /*
            ---------------加载xml配置---------------
            User对象被实例化...
            ---------------获取bean对象---------------
            true
         */
        User user = ctx.getBean("user", User.class);
        User user2 = ctx.getBean("user", User.class);
        System.out.println(user == user2);
    }

    /**
     * lazy-init让对象在获取时才进行创建
     */
    @Test
    public void lazyInitTest() {
        System.out.println("---------------加载xml配置---------------");
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-lazyInit.xml");
        System.out.println("---------------获取bean对象---------------");
        /*
            ---------------加载xml配置---------------
            ---------------获取bean对象---------------
            User对象被实例化...
         */
        ctx.getBean("user", User.class);
    }


    /**
     * 多例模式，获取时才创建bean
     */
    @Test
    public void protoTypeTest() {
        System.out.println("---------------加载xml配置---------------");
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-protoType.xml");
        System.out.println("---------------获取bean对象---------------");
        User user = ctx.getBean("user", User.class);
        User user2 = ctx.getBean("user", User.class);
        System.out.println(user == user2);
    }

    /**
     * 单例bean的生命周期
     */
    @Test
    public void singletonLifeTest() {
        /*
            User对象被实例化...
            User的init方法被执行...
            User的destroy方法被执行...
         */
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-lifeCycle-singleton.xml");
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
            User的init方法被执行...
            User对象被实例化...
            User的init方法被执行...
         */
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-lifeCycle-protoType.xml");
        ctx.getBean("user", User.class);
        ctx.getBean("user", User.class);
        // 销毁容器
        ctx.close();
    }
}