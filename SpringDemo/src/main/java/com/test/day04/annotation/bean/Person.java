package com.test.day04.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component作用等同于<bean></bean>标签，用于注册bean,id默认为类名称首字母小写
 * 和@Component注解功能类似的注解还有
 * @Controller  Controller层的Component
 * @Service     Service层的Component
 * @Repository  Dao层的Component
 */
@Component
public class Person {
    @Value("张三")
    private String name;
    @Value("20")
    private int age;
    @Autowired
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }
}
