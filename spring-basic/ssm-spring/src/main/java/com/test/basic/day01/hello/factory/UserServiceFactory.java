package com.test.basic.day01.hello.factory;

import com.test.basic.day01.hello.dao.UserMysqlDaoImpl;
import com.test.basic.day01.hello.service.UserService;
import com.test.basic.day01.hello.service.UserServiceImpl;

/**
 * 静态工厂类，不需要先实例化UserServiceFactory类
 */
public class UserServiceFactory {
    public static UserService getUserService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserMysqlDaoImpl());
        return userService;
    }
}
