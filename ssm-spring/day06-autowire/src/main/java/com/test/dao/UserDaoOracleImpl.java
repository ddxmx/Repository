package com.test.dao;

import org.springframework.stereotype.Component;

/**
 * Dao接口oracle实现
 */
@Component
public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("oracle get user");
    }
}
