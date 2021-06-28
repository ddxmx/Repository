package com.test.day01.hello.factory;

import com.test.day01.hello.dao.UserDaoImpl;
import com.test.day01.hello.service.UserService;
import com.test.day01.hello.service.UserServiceImpl;

/**
 * 静态工厂类
 */
public class UserServiceFactory {
    public static UserService getUserService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl());
        return userService;
    }
}
