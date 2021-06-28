package com.test.day09.mybatis.dao;


import com.test.day09.mybatis.bean.User;

public interface UserDao {

    //根据ID查询用户
    public User getUserById(int id);
}
