package com.test.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    @Test
    public void testHello() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        HelloSpring helloBean = context.getBean("hello", HelloSpring.class);
        helloBean.show();
    }

    @Test
    public void testUserDaoImpl() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        UserServiceImpl service = context.getBean("userServiceImpl", UserServiceImpl.class);
        service.printUser();
    }
}
