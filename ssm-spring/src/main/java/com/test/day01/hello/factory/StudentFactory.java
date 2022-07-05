package com.test.day01.hello.factory;

import com.test.day01.hello.bean.Student;

/**
 * 非静态工厂类，使用时需要先实例化工厂类对象
 */
public class StudentFactory {
    public Student getStudent() {
        return new Student();
    }
}
