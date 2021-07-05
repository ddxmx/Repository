package com.test.mybatis.dao;

import com.test.mybatis.pojo.Blog;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest {
    @Test
    public void addBlog() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = new Blog("ABC123", "一千零一夜", "张三", new Date(), 9999);
            mapper.addBlog(blog);
        }
    }

    @Test
    public void getBlogByTitleOrAuthor() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "java开发实战经典");
            map.put("author", "奥德赛");
            List<Blog> list = mapper.getBlogByTitleOrAuthor(map);
            list.forEach(System.out::println);
        }
    }

    @Test
    public void updateBlog() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId("ABC123");
            blog.setTitle("MySQL数据库");
            blog.setAuthor("张飞");
            mapper.updateBlog(blog);
        }
    }

    @Test
    public void getBlogByTitleChoiceAuthor() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setTitle("java开发实战经典");
            blog.setAuthor("奥德赛");
            List<Blog> list = mapper.getBlogByTitleChoiceAuthor(blog);
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getBlogForeach() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            List<String> ids = Arrays.asList("ABC123", "112");
            List<Blog> list = mapper.getBlogForeach(ids);
            list.forEach(System.out::println);
        }
    }
}