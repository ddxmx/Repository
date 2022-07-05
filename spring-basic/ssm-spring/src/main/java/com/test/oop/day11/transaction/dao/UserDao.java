package com.test.oop.day11.transaction.dao;


import com.test.oop.day11.transaction.bean.User;

public interface UserDao {
    public void addUser(User user);

    public void deleteUser(int id);
}
