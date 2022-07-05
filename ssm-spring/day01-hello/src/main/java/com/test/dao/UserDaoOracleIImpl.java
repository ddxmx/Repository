package com.test.dao;

/**
 * Dao接口实现二
 */
public class UserDaoOracleIImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("oracle get user");
    }
}
