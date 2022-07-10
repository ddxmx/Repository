package com.test.dao;

import org.springframework.stereotype.Component;

/**
 * Dao接口mysql实现
 */
@Component
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mysql get user");
    }
}
