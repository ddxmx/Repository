package com.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan

/**
 * 默认 @ComponentScan 只会扫描当前包和子包
 * 注解要放在已经在容器中注册的类上，才能使注解生效，否则无法注解注解的系统实现类
 */
public class Person {
    @Value("jack")
    private String name;
    @Value("20")
    private int age;
    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;

    @Override
    public String toString() {
        return "姓名：" + this.name + "，年龄：" + age
                + "，狗狗的名字：" + this.dog.getName() + ",猫的名字：" + this.cat.getName();
    }
}
