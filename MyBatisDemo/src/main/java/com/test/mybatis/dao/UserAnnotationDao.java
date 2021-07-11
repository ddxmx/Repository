package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 注解方式的sql语句
 * 注解方式不再需要sql映射文件，但是只适合于一些简单的SQL语句
 */
public interface UserAnnotationDao {
    //不管是注解方式和xml方式，一个参数时，可以不使用@Param注解
    @Select("select * from mybatis.user where id=#{id}")
    public User getUserById(int id);

    @Select("select * from mybatis.user")
    public List<User> getUsers();

    @Insert("insert into mybatis.user value (#{id},#{name},#{age})")
    public int addUser(User user);

    @Update("update mybatis.user set name=#{name},age=#{age} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from mybatis.user where id=#{id}")
    public int deleteUser(int id);
}
