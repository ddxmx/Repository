package com.test.day10.mybatis.dao;


import com.test.day10.mybatis.bean.User;

public interface UserDao {
    //根据ID查询用户
    public User getUserById(int id);
}
