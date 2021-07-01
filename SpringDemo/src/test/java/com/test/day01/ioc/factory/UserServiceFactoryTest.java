package com.test.day01.ioc.factory;

import com.test.day01.ioc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceFactoryTest {
    @Test
    public void staticFactoryTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc-factory.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}