package com.test.mybatis.dao;

import com.github.pagehelper.PageHelper;
import com.test.mybatis.pojo.User;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * 使用xml配置sql语句
 */
public class UserDaoTest {
    @Test
    public void getUserById() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            User user = mapper.getUserById(1002);
            //User(id=1002, name=李四, age=24)
            System.out.println(user);
        }
    }

    @Test
    public void getAllUsers() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getAllUsers();
            /*
                User(id=1001, name=张三, age=20)
                User(id=1002, name=李四, age=24)
                User(id=1003, name=王五, age=21)
                User(id=1004, name=赵六, age=20)
                User(id=1005, name=tom, age=23)
                User(id=1006, name=jerry, age=22)
             */
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByIdOrName() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByIdOrName(1004, "李四");
            /*
                User(id=1002, name=李四, age=24)
                User(id=1004, name=赵六, age=20)
             */
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByMap() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            Map<String, Object> map = new HashMap<>();
            map.put("uid", 1004);
            map.put("uname", "李四");
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByMap(map);
            /*
                User(id=1002, name=李四, age=24)
                User(id=1004, name=赵六, age=20)
             */
            list.forEach(System.out::println);
        }
    }

    @Test
    public void addUser() {
        try (SqlSession session = MyBatisUtil.getSession();) {
            UserDao mapper = session.getMapper(UserDao.class);
            User user = new User(1007, "jack", 19);
            int count = mapper.addUser(user);
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession session = MyBatisUtil.getSession();) {
            UserDao mapper = session.getMapper(UserDao.class);
            User user = new User(1007, "helen", 18);
            int count = mapper.updateUser(user);
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            int count = mapper.deleteUser(1007);
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void getUserLikeName() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserLikeName("%赵%");
            /*
                User{id=1004, name='赵六', age=20}
                User{id=1000, name='赵四', age=22}
             */
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserWith$() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            //List<User> list = mapper.getUserWith$("'王五'");

            //使用#{}方式，查询出来是空结果
            //使用${}方式，查询出来是所有数据
            //使用#方式传递字符串时不需要在字符串上手动传入单引号，$方式需要手动传入
            List<User> list = mapper.getUserWith$("'王五' or 1=1");
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUsersWithPageHelper() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            //实际上就是拦截器，加上了limit参数
            /*
                User{id=1003, name='王五', age=21}
                User{id=1004, name='赵六', age=20}
             */
            PageHelper.startPage(2, 2);
            List<User> list = mapper.getUsersWithPageHelper();
            list.forEach(System.out::println);
        }
    }

    @Test
    public void count() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            int count = mapper.count();
            System.out.println("总条数：" + count);
        }
    }
}