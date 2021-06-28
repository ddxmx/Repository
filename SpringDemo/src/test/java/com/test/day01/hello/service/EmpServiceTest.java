package com.test.day01.hello.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpServiceTest {

    /**
     * 通过多个xml文件注入bean
     */
    @Test
    public void save() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc.xml", "day01-ioc-emp.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        EmpService empService = context.getBean("empService", EmpService.class);
        empService.save();
    }

    /**
     * 通过在xml使用import方式注入bean
     */
    @Test
    public void importTest() {
        //在一个xml配置文件合并其他xml配置文件
        //<import resource="day01-hello-emp.xml"/>
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        EmpService empService = context.getBean("empService", EmpService.class);
        empService.save();
    }
}