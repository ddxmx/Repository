package com.test.factory;

import com.test.bean.Person;

/**
 * 静态工厂类，不需要先实例化PersonStaticFactory类
 */
public class PersonStaticFactory {
    public static Person getInstance() {
        return new Person();
    }
}
