package com.test.day01.hello.factory;

import com.test.day01.hello.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpServiceFactoryTest {
    @Test
    public void instanceFactoryTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc-factory.xml");
        EmpService empService = context.getBean("empService", EmpService.class);
        empService.save();
    }
}