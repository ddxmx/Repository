package com.test.service;

import com.test.dao.UserDao;

public class UserServiceImpl implements UserService {
    // service和dao强耦合
    //private UserDao userDao = new UserDaoImpl();

    private UserDao userDao;

    //解耦，dao的实例由外部传入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        System.out.println(userDao.getUser());
    }
}
