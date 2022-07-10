package com.test.service;

import com.test.dao.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserServiceResourceImpl implements UserService {
    @Resource(name = "userDaoOracleImpl")
    private UserDao userDao;

    /**
     * service调用dao层操作
     */
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
