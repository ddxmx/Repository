package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    //根据ID查询用户
    public User getUserById(int id);

    //查询所有用户
    public List<User> getUsers();

    //mapper.xml中select语句设置时，参数只能是一个，如果传参是两个，可以在接口方法的参数前加 @Param属性，值匹配就可以
    //Sql语句编写的时候，直接取@Param中设置的值即可，不需要单独设置参数类
    public List<User> getUserByIdAndName(@Param("id") int id, @Param("name_test") String name);

    //使用map进行传参，实际上只是将多个参数封装为一个map传入
    public List<User> getUserByIdAndName2(Map<String, Object> map);

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(@Param("id") int id);

    //模糊查看，不要在mapper.xml中拼接%的字符串，可能会带来sql注入的风险
    public List<User> getUserByLikeName(String name);

    /**
     * 分页查询
     * 分页sql格式是：select * from table limit (start-1)*pageSize,pageSize; 其中start是页码，pageSize是每页显示的条数。
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<User> getUserByPage(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);
}
