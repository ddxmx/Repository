package com.test.dao;


import com.test.bean.User;

public interface UserDao {
    public void addUser(User user);

    public void deleteUser(int id);
}
