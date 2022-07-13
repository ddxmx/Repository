package com.test;

import com.test.bean.User;
import com.test.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {
    @Test
    public void getUserById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day10-mybatis.xml");
        UserDao userDao = context.getBean(UserDao.class);
        User user = userDao.getUserById(1001);
        System.out.println(user);
    }
}