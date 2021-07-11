package com.test.mybatis.dao;

import com.test.mybatis.pojo.Blog;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest {
    @Test
    public void getBlogByTitleOrAuthor() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogDao mapper = session.getMapper(BlogDao.class);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "java开发实战经典");
            map.put("author", "jerry");
            List<Blog> list = mapper.getBlogByTitleOrAuthor(map);
            /*
                Blog(id=111, title=java开发实战经典, author=李兴华, createTime=Fri Jan 03 21:21:11 CST 2020, views=5490)
                Blog(id=112, title=python基础教程, author=jerry, createTime=Wed Jan 06 23:24:35 CST 2021, views=6811)
             */
            list.forEach(System.out::println);
        }
    }

    @Test
    public void updateBlog() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogDao mapper = session.getMapper(BlogDao.class);
            Blog blog = new Blog();
            blog.setId("112");
            blog.setTitle("python基础教程第三版");
            blog.setAuthor("jerry");
            mapper.updateBlog(blog);
        }
    }

    @Test
    public void getBlogByTitleChoiceAuthor() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogDao mapper = session.getMapper(BlogDao.class);
            Blog blog = new Blog();
            blog.setTitle("java开发实战经典");
            blog.setAuthor("jerry");
            List<Blog> list = mapper.getBlogByTitleChoiceAuthor(blog);
            //Blog(id=111, title=java开发实战经典, author=李兴华, createTime=Fri Jan 03 21:21:11 CST 2020, views=5490)
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getBlogForeach() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            BlogDao mapper = session.getMapper(BlogDao.class);
            List<String> ids = Arrays.asList("110", "112");
            List<Blog> list = mapper.getBlogForeach(ids);
            /*
                Blog(id=110, title=MySQL数据库, author=张三, createTime=Mon Jul 05 22:57:23 CST 2021, views=3981)
                Blog(id=112, title=python基础教程第三版, author=jerry, createTime=Wed Jan 06 23:24:35 CST 2021, views=6811)
             */
            list.forEach(System.out::println);
        }
    }
}