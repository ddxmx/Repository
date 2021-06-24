package com.test.namespace;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void userTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void singletonTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        //容器实例化对象，默认单例模式
        System.out.println(user1 == user2); //true
    }

    @Test
    public void prototypeTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1 == user2); //false
        System.out.println(user1); //User{name='tom', age=30}
        System.out.println(user2); //User{name='tom', age=30}
    }
}