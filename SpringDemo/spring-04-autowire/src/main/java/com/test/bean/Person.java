package com.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 使用@Autowired注解，可以不用写set方法
 * Autowired是先根据type，再根据name，不支持设置名称
 * Resource可以指定名称，是先根据name，再根据type
 * Qualifier可以指定名称，想按名称装配，除了使用@Resource外，可以联合使用@Autowired和@Qualifier
 */
public class Person {
    private String name;

    //@Resource(name = "dog2")
    @Qualifier("dog2")
    @Autowired
    private Dog dog;

    @Autowired
    private Cat cat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
