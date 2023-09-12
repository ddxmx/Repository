package com.test.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * set注入依赖方式必须要有set方法
 */
@Data
public class Member {
    private String name;
    private int age;
    private boolean male;
    private String wife;
    private Car car;
    private String[] books;
    private List<String> hobbies;
    private Map<String, String> family;
    private Set<String> games;
    private Properties scores;
}
