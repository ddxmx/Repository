package com.test.dao;

/**
 * Dao接口mysql实现
 */
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mysql get user");
    }
}
