package com.test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user") //衍生的三个注解 @Controller @Service @Repository
public class User {
    @Value("jerry") //在属性上设置值，可以不提供set方法
    private String name;

    public String getName() {
        return name;
    }

    @Value("tom") //在set方法上设置值，会覆盖在属性上设置的值
    public void setName(String name) {
        this.name = name;
    }
}
