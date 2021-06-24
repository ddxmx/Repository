package com.test.dao;

import com.test.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void userTest() {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("application-context.xml");
        UserDaoImpl userDao = context.getBean("userDao", UserDaoImpl.class);
        User user = userDao.getUserById(1002);
        System.out.println(user);
    }

    @Test
    public void userTest2() {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("application-context2.xml");
        UserDaoImpl2 userDao = context.getBean("userDao", UserDaoImpl2.class);
        User user = userDao.getUserById(1002);
        System.out.println(user);
    }

}