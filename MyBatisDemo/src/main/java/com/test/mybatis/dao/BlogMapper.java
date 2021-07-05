package com.test.mybatis.dao;

import com.test.mybatis.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * 动态SQL的使用
 */
public interface BlogMapper {
    public int addBlog(Blog blog);

    public List<Blog> getBlogByTitleOrAuthor(Map<String, Object> map);

    public int updateBlog(Blog blog);

    public List<Blog> getBlogByTitleChoiceAuthor(Blog blog);

    public List<Blog> getBlogForeach(List<String> ids);
}
