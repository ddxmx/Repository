package com.test.day05.life.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    @Test
    public void scopeSingletonTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day05-life.xml");
        System.out.println("===========================================");
        User user = context.getBean("user", User.class);
        user.show();
        User user2 = context.getBean("user", User.class);
        System.out.println(user == user2);
    }

    @Test
    public void initDestroyTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day05-life.xml");
        context.getBean("user", User.class);
        //关闭容器才会调用destroy方法
        context.close();
    }
}