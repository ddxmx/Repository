package com.test.dao;

/**
 * Dao接口oracle实现
 */
public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("oracle get user");
    }
}
