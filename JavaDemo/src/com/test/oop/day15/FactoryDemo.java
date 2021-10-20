package com.test.oop.day15;

interface Fruit {
    public void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("Apple.eat");
    }
}

class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("Orange.eat");
    }
}

/**
 * 工厂类，用于生产实例化对象
 */
class FruitFactory {
    public static Fruit getInstance(String className) {
        Fruit fruit = null;

        try {
            Object instance = Class.forName(className).newInstance();
            if (instance instanceof Fruit) {
                fruit = (Fruit) instance;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return fruit;
    }
}

/**
 * 工厂设计模式
 * 用于客户端解耦，通过工厂获取实例化对象
 */
public class FactoryDemo {
    public static void main(String[] args) {
        Fruit fruit = FruitFactory.getInstance(Orange.class.getName());
        if (null != fruit) {
            fruit.eat(); // Orange.eat
        }
    }
}
