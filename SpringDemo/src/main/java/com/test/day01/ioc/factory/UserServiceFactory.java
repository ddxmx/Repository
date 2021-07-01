package com.test.day01.ioc.factory;

import com.test.day01.ioc.dao.UserDaoImpl;
import com.test.day01.ioc.service.UserService;
import com.test.day01.ioc.service.UserServiceImpl;

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
