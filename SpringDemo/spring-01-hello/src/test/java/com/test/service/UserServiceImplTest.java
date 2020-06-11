package com.test.service;

import com.test.dao.UserDaoImpl;
import com.test.dao.UserDaoMysqlImpl;
import org.junit.Test;

public class UserServiceImplTest {
    @Test
    public void printUser() {
//        UserService service = new UserServiceImpl();
//        service.printUser();

        UserServiceImpl service = new UserServiceImpl();
        service.setUserDao(new UserDaoImpl());
        service.printUser();

        UserServiceImpl service2 = new UserServiceImpl();
        service2.setUserDao(new UserDaoMysqlImpl());
        service2.printUser();
    }
}