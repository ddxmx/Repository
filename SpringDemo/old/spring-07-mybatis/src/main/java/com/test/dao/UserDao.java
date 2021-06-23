package com.test.dao;

import com.test.bean.User;

public interface UserDao {

    //根据ID查询用户
    public User getUserById(int id);
}
