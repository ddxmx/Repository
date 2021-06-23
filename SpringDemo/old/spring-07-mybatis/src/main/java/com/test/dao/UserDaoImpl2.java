package com.test.dao;

import com.test.bean.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * mapper和dao绑定
 * dao实现类中调用dao的接口获取结果
 */
public class UserDaoImpl2 extends SqlSessionDaoSupport implements UserDao {
    public User getUserById(int id) {
        UserDao mapper = getSqlSession().getMapper(UserDao.class);
        return mapper.getUserById(id);
    }
}
