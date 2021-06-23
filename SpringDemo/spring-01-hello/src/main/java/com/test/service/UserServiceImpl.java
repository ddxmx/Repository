package com.test.service;

import com.test.dao.UserDao;

public class UserServiceImpl implements UserService {
    //代码强耦合具体的DAO实现类
    //private UserDao userDao = new UserDaoImpl();
    //private UserDao userDao = new UserDaoMysqlImpl();
    //private UserDao userDao = new UserDaoOraclelImpl();

    private UserDao userDao;

    //DAO的选择交给用户
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        System.out.println(userDao.getUser());
    }
}
