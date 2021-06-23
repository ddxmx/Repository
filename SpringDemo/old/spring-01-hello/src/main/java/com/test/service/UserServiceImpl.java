package com.test.service;

import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    //    private UserDao userDao = new UserDaoImpl();
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void printUser() {
        System.out.println(userDao.getUser());
    }
}
