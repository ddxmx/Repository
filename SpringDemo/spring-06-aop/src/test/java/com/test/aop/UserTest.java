package com.test.aop;

import com.test.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void userTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = context.getBean("user", User.class);
        user.add();
        System.out.println("************************");
        user.delete();
    }

    @Test
    public void userTest2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context2.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}