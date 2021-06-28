package com.test.day01.hello.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserServicelTest {

    /**
     * 通过相对路径获取IOC容器中对象
     */
    @Test
    public void add() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 通过绝对路径获取IOC容器中对象
     */
    @Test
    public void FileSystemXmlTest() {
        String filePath = "E:\\IdeaProjects\\spring-basic\\ssm-spring\\src\\main\\resources\\day01-ioc.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(filePath);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}