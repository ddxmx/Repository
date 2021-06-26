package com.test.factory;

import com.test.ioc.Fruit;

/**
 * 静态工厂类
 */
public class FruitFactory {
    public static Fruit getFruit(){
        return new Fruit();
    }
}
