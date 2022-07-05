package com.test.factory;

import com.test.bean.Person;

/**
 * 非静态工厂类，使用时需要先实例化工厂类对象
 */
public class PersonFactory {
    public Person getInstance() {
        return new Person();
    }
}
