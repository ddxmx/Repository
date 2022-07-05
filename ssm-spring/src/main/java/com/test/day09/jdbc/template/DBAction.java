package com.test.day09.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DBAction {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add() {
        //新增操作
        String sql = "insert into user(id,name, age) values(?,?,?)";
        jdbcTemplate.update(sql, 2001, "Smith", 26);
    }

    public void update() {
        //修改操作
        String sql = "update user set age=? where id=?";
        int count = jdbcTemplate.update(sql, "28", 2001);
    }

    public void delete() {
        //删除操作
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, 2001);
    }

    public void selectOne() {
        //查询单个数据
        User user = new User();
        String sql = "select * from user where id = ?";
        Object[] arr = new Object[]{1001};
        jdbcTemplate.query(sql, (rs) -> {
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
        }, arr);
        System.out.println(user);
    }

    public void selectList() {
        //查询多条数据
        User user = new User();
        String sql = "select * from user where id in (?,?)";
        Object[] arr = new Object[]{1001, 1002};
        List<User> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
        }, arr);
        System.out.println(list);
    }

    public void count(){
        //查询总记录数
        String sql = "select count(1) from user";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
