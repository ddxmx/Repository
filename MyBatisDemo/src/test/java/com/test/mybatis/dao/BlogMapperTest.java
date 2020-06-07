package com.test.mybatis.dao;

import com.test.mybatis.pojo.Blog;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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
    public void getBlogsByTitleOrAuthor() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "JAVA开发");
//            map.put("author", "王五");
            List<Blog> list = mapper.getBlogsByTitleOrAuthor(map);
            list.forEach(System.out::println);
        }
    }

    @Test
    public void updateBlog() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId("ABC126");
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
            blog.setTitle("JAVA开发");
            blog.setAuthor("王五");
            List<Blog> list = mapper.getBlogByTitleChoiceAuthor(blog);
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getBlogForeach() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            List<String> ids = Arrays.asList("ABC123", "ABC124", "ABC125");
            List<Blog> list = mapper.getBlogForeach(ids);
            list.forEach(System.out::println);
        }
    }
}