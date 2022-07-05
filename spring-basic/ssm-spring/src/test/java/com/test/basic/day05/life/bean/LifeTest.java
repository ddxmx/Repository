package com.test.basic.day05.life.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    @Test
    public void scopeSingletonTest() {
        //初始化IOC容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day05-life.xml");
        System.out.println("===========================================");
        //获取bean对象
        User user = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user == user2);
        //关闭容器
        context.close();
    }
}