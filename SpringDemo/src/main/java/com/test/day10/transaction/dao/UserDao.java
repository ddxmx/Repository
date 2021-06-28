package com.test.day10.transaction.dao;


import com.test.day10.transaction.bean.User;

public interface UserDao {

    public void addUser(User user);

    public void deleteUser(int id);
}
