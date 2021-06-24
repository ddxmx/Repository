package com.test.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {
    @Test
    public void helloTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Hello hello = context.getBean("hello", Hello.class);
        Hello myhello = context.getBean("myhello", Hello.class);
        Hello hello2 = context.getBean("hello2", Hello.class);
        Hello hello3 = context.getBean("hello3", Hello.class);
        Hello hello4 = context.getBean("hello4", Hello.class);
        //bean实例化默认是单例模式
        System.out.println(hello == myhello); //true
        System.out.println(hello == hello2); //true
        System.out.println(hello == hello3); //true
        System.out.println(hello == hello4); //true
        hello.show();
    }

    @Test
    public void userTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user); //User{name='tom', age=20}
    }
}