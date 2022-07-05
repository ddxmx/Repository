package com.test.service;

import com.test.dao.UserDaoMysqlImpl;
import com.test.dao.UserDaoOracleIImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void getUser() {
        UserServiceImpl service = new UserServiceImpl();
        // 传入mysql dao实现类
        service.setUserDao(new UserDaoMysqlImpl());
        service.getUser(); // mysql get user
        // 传入oracle dao实现类
        service.setUserDao(new UserDaoOracleIImpl());
        service.getUser(); // oracle get user
    }

    @Test
    public void springGetUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.getUser();
    }
}