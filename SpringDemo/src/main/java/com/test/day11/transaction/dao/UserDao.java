package com.test.day11.transaction.dao;


import com.test.day11.transaction.bean.User;

public interface UserDao {
    public void addUser(User user);

    public void deleteUser(int id);
}
