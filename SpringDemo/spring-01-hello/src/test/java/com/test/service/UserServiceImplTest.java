package com.test.service;

import com.test.dao.UserDaoImpl;
import com.test.dao.UserDaoMysqlImpl;
import org.junit.Test;

public class UserServiceImplTest {
    @Test
    public void getUser() {
        //UserService service = new UserServiceImpl();
        //service.getUser();

        /*
            测试类手动new对象
         */
        UserServiceImpl service = new UserServiceImpl();
        service.setUserDao(new UserDaoImpl());
        service.getUser(); //本地获取用户信息

        UserServiceImpl service2 = new UserServiceImpl();
        service2.setUserDao(new UserDaoMysqlImpl());
        service2.getUser(); //Mysql返回用户信息
    }
}