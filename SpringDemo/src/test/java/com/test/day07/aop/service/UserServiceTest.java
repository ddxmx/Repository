package com.test.day07.aop.service;

import com.test.day07.aop.config.LogConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void aspectAnnotationTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day07-aop.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.getUser();
    }

    @Test
    public void aspectAnnotationTest2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(LogConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.getUser();
    }

    @Test
    public void aspectXmlTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day07-aop-xml.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.getUser();
    }
}