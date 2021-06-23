package com.test.dao;

import com.test.bean.User;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * mapper和dao绑定
 * dao实现类中调用dao的接口获取结果
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionTemplate template;

    public UserDaoImpl(SqlSessionTemplate template) {
        this.template = template;
    }

    public User getUserById(int id) {
        UserDao mapper = template.getMapper(UserDao.class);
        return mapper.getUserById(id);
    }
}
