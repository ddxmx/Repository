package com.test.oop.day15;

interface Fruit {
    public void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}

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
 */
public class FactoryDemo {
    public static void main(String[] args) {
        Fruit fruit = FruitFactory.getInstance("com.test.oop.day15.Orange");
        if (null != fruit) {
            fruit.eat();
        }
    }
}
