package com.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {
    @Test
    public void helloTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//        Hello helloBean = context.getBean("hello", Hello.class);
        Hello helloBean = context.getBean("myhello", Hello.class);
        Hello helloBean2 = context.getBean("hello2", Hello.class);
        Hello helloBean3 = context.getBean("hello3", Hello.class);
        Hello helloBean4 = context.getBean("hello4", Hello.class);
        helloBean.show();
    }

    @Test
    public void userTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}