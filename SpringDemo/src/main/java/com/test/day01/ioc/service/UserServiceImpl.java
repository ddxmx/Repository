package com.test.day01.ioc.service;

import com.test.day01.ioc.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        userDao.add();
    }
}
