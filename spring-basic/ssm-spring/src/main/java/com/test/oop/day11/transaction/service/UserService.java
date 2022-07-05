package com.test.oop.day11.transaction.service;

import com.test.oop.day11.transaction.bean.User;
import com.test.oop.day11.transaction.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 注解方式的事务开启
     * 使用@Transactional注解，同时
     * xml中配置 <tx:annotation-driven transaction-manager="transactionManager"/>
     *
     * @param user
     * @param id
     */
    //@Transactional
    public void doUser(User user, int id) {
        userDao.addUser(user);
        //System.out.println(10 / 0);
        userDao.deleteUser(id);
    }
}
