package com.test.service;

import com.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServicePrimaryImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * service调用dao层操作
     */
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
