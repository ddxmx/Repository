package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 使用xml配置sql语句
 */
public class UserDaoTest {
    @Test
    public void getUserById() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            User user = mapper.getUserById(1002);
            System.out.println(user);
        }
    }

    @Test
    public void getUsers() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUsers();
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByIdAndName() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByIdAndName(1004, "zhuliu");
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByMap() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            Map<String, Object> map = new HashMap<>();
            //mapper.xml直接使用key值设置值
            map.put("pid", 1003);
            map.put("pname", "wangwu");
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByMap(map);
            list.forEach(System.out::println);
        }
    }

    @Test
    public void addUser() {
        try (SqlSession session = MyBatisUtil.getSession();) {
            UserDao mapper = session.getMapper(UserDao.class);
            User user = new User(1006, "scott", 30);
            int count = mapper.addUser(user);
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession session = MyBatisUtil.getSession();) {
            UserDao mapper = session.getMapper(UserDao.class);
            String name = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
            User user = new User(1006, name, 18);
            int count = mapper.updateUser(user);
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            int count = mapper.deleteUser(1006);
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void getUserByLikeName() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByLikeName("%li%");
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByPage() {
        /*
            User(id=1002, name=lisi, age=24)
            User(id=1003, name=wangwu, age=21)
         */
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByPage(1, 2);
            list.forEach(System.out::println);
        }
    }
}