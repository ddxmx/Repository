package com.test.day01.hello.factory;

import com.test.day01.hello.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceFactoryTest {
    /**
     * 静态工厂获取bean
     */
    @Test
    public void staticFactoryTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc-factory.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}