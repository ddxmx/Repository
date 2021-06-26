package com.test.service;

import com.test.bean.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过Spring的方式管理bean，从Spring中获取实例化对象
 */
public class ApplicationContextTest {
    @Test
    public void testHello() {
        //通过ClassPathXmlApplicationContext对象获取IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Hello helloBean = context.getBean("hello", Hello.class);
        helloBean.show();
    }

    @Test
    public void testUserDaoImpl() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        UserServiceImpl service = context.getBean("userServiceImpl", UserServiceImpl.class);
        service.getUser();
    }
}
