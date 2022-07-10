package com.test.service;

import com.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceQualifierImpl implements UserService {
    @Autowired
    @Qualifier("userDaoMysqlImpl")
    private UserDao userDao;

    /**
     * service调用dao层操作
     */
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
