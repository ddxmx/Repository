package com.test.dao;

/**
 * Dao接口实现一
 */
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mysql get user");
    }
}
