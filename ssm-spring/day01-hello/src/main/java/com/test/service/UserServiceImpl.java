package com.test.service;

import com.test.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    /**
     * service和dao解耦，由调用方传入dao的实现类，而不需要修改service的代码
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * service调用dao层操作
     */
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
