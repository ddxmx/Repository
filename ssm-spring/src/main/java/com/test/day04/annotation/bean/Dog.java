package com.test.day04.annotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//作用和xml中<bean>标签一致
@Component
public class Dog {
    //通过反射机制给基本数据类型和String赋值
    @Value("大黄")
    private String name;

    public void cry() {
        System.out.println("汪汪汪~");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
