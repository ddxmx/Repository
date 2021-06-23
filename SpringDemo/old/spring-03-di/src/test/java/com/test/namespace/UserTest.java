package com.test.namespace;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void userTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1);
        //默认就是singleton
        System.out.println(user1 == user2);
    }
}