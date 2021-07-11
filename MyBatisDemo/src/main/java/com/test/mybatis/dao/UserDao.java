package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * xml的sql语句
 */
public interface UserDao {
    //根据ID查询用户
    public User getUserById(int id);

    //查询所有用户
    public List<User> getAllUsers();

    //mapper中select语句设置时，参数只能是一个，如果传参是两个，可以在接口方法的参数前加@Param属性
    //Sql语句编写的时候，直接取@Param中设置的值即可，不需要单独设置参数类型
    public List<User> getUserByIdOrName(@Param("id") int id, @Param("name_test") String name);

    //使用map进行传参，实际上是将多个参数封装为一个map传入
    public List<User> getUserByMap(Map<String, Object> map);

    //新增一个用户
    public int addUser(User user);

    //修改一个用户
    public int updateUser(User user);

    //删除一个用户
    public int deleteUser(int id);

    //模糊查询
    public List<User> getUserLikeName(String name);

    //使用${}查询
    public List<User> getUserWith$(String name);

    //使用分页插件
    public List<User> getUsersWithPageHelper();
}
