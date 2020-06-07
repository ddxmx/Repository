package com.test.mybatis.jdbc;

import com.test.mybatis.pojo.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 传统JDBC操作数据库的方式，所有的操作完全由用户手工控制
 */
public class JDBCDemo {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private static final String NAME = "root";
    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, NAME, PASSWORD);
    }

    @Test
    public void queryAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "select * from mybatis.user";
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
    }

    @Test
    public void insertUser() {
        try (Connection conn = getConnection()) {
            String sql = "insert into mybatis.user(id,name,age) values(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, 1006);
            stat.setString(2, "scott");
            stat.setInt(3, 30);

            int count = stat.executeUpdate();
            System.out.println("更新了 " + count + " 条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
