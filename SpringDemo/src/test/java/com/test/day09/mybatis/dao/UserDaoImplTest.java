package com.test.day09.mybatis.dao;

import com.test.day09.mybatis.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {
    @Test
    public void getUserById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day09-mybatis.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        User user = userDao.getUserById(1001);
        System.out.println(user);
    }
}