package com.test.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void instanceTest1() {
//        new User();
    }

    @Test
    public void instanceTest2() {
        //第一行执行完，就已经实例化完成了bean对象
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = (User) context.getBean("user3");
        user.show();
    }

    @Test
    public void instanceTest3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        System.out.println(user == user2); //true
    }

    @Test
    public void aliasTest4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = (User) context.getBean("testuser");
        user.show();
        User user2 = (User) context.getBean("user");
        user2.show();
        User user3 = (User) context.getBean("myuser3");
        user3.show();
    }

    @Test
    public void importTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = (User) context.getBean("myuser3");
        user.show();

        //bean id冲突会出现异常
        //java.lang.ClassCastException: com.test.ioc.User cannot be cast to com.test.ioc.Person
        Person person = (Person) context.getBean("user");
        person.show();
    }
}