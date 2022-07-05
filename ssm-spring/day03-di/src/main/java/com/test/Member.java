package com.test;

import lombok.Data;
import lombok.ToString;

import java.util.*;

/**
 * set注入依赖方式必须要有set方法
 */
@Data
@ToString
public class Member {
    private String name;
    private int age;
    private Car car;
    private String[] books;
    private List<String> hobbies;
    private Map<String, String> parents;
    private Set<String> games;
    private String wife;
    private Properties info;
}
