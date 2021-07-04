package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * use表查询接口
 */
public interface UserDao {

    //根据ID查询用户
    public User getUserById(int id);

    //查询所有用户
    public List<User> getUsers();

    //mapper.xml中select语句设置时，参数只能是一个，如果传参是两个，可以在接口方法的参数前加 @Param属性
    //Sql语句编写的时候，直接取@Param中设置的值即可，不需要单独设置参数类型
    public List<User> getUserByIdAndName(@Param("id") int id, @Param("name_test") String name);

    //使用map进行传参，实际上只是将多个参数封装为一个map传入
    public List<User> getUserByMap(Map<String, Object> map);

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);

    //模糊查询，不要在mapper.xml中使用%拼接字符串，存在sql注入的风险
    public List<User> getUserByLikeName(String name);

    /**
     * 分页查询
     * SELECT * FROM table LIMIT 5,10; // 检索记录行 6-15，第一个参数表示开始的索引位置，第二个参数表示返回数据量
     *
     * @param startIndex 开始检索的索引，从0开始
     * @param pageSize   每页显示的条数
     * @return
     */
    public List<User> getUserByPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
}
