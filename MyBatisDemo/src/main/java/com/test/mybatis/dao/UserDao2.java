package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 注解方式不再需要mapper.xml文件，但是只适合于一些简单的SQL语句
 */
public interface UserDao2 {
    //不管是注解方式和xml方式，一个参数时，可以不使用@Param注解
    @Select("select * from mybatis.user where id=#{id}")
    public User getUserById(int id);

    @Select("select * from mybatis.user")
    public List<User> getUsers();

    public User getUserById2(int id);

    @Insert("insert into mybatis.user value (#{id1},#{name},#{age})")
    public int addUser(User user);

    @Update("update mybatis.user set name=#{name},age=#{age} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from mybatis.user where id=#{id}")
    public int deleteUser(int id);
}
