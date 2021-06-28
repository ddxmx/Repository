package com.test.day10.transaction.dao;

import com.test.day10.transaction.bean.User;
import org.mybatis.spring.SqlSessionTemplate;

public class UserDaoImpl implements UserDao {
    private SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }

    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    public void addUser(User user) {
        UserDao mapper = template.getMapper(UserDao.class);
        mapper.addUser(user);
    }

    public void deleteUser(int id) {
        UserDao mapper = template.getMapper(UserDao.class);
        mapper.deleteUser(id);
    }

    public void trans(User user) {
        addUser(user);
        deleteUser(user.getId());
    }
}
