package com.test.service;

import com.test.dao.UserDaoOraclelImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void getUser() {
//        UserService userService = new UserServiceImpl();
//        userService.getUser();

        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoOraclelImpl());
        userService.getUser();
    }

    @Test
    public void getUser2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.getUser();
    }
}