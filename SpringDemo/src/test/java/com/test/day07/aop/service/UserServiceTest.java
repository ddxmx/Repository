package com.test.day07.aop.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void aspectTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day07-aop.xml");
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