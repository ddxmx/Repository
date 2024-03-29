package com.test.oop.day08.polymorphic;

class User {
    public void sleep() {
        System.out.println("User.sleep");
    }

    public void eat() {
        System.out.println("User.eat");
    }
}

/**
 * Consumer类覆写了父类方法，同时定义了新的方法
 */
class Consumer extends User {
    @Override
    public void sleep() {
        System.out.println("Consumer.sleep");
    }

    @Override
    public void eat() {
        System.out.println("Consumer.eat");
    }

    public void consume() {
        System.out.println("Consumer.consume");
    }
}

/**
 * Producer类继承父类方法，同时定义了新的方法
 */
class Producer extends User {
    public void produce() {
        System.out.println("Producer.produce");
    }
}

public class DowncastingDemo {
    public static void main(String[] args) {
        System.out.println("********************向上转型，可以调用的方法取决于声明类型********************");
        User user1 = new Consumer();
        user1.sleep(); // Consumer.sleep
        user1.eat(); // Consumer.eat
        // 编译错误，user1是User类型，其中没有定义consume方法，方法是否可以被调用取决于声明类型
        // user1.consume();

        System.out.println("*******************向下转型，使用instanceof判断对象是否是类的实例*********************");
        User user2 = new Producer();
        // 编译成功，运行失败，java.lang.ClassCastException: Producer cannot be cast to Consumer
        // Consumer consumer2 = (Consumer) user2;

        // 为了避免向下转型出现异常，在向下转型前使用instanceof判断对象是否是类的实例
        if (user2 instanceof Consumer) {
            ((Consumer) user2).consume();
        } else if (user2 instanceof Producer) {
            ((Producer) user2).produce(); // Producer.produce
        }

        System.out.println(user2 instanceof User); // true
        System.out.println(user2 instanceof Consumer); // false
        System.out.println(user2 instanceof Producer); // true

        System.out.println("*******************实例类型和声明类型存在父子关系才允许转型*********************");
        Object obj = new Consumer();
        // 编译运行都通过
        User user3 = (User) obj;
        // 编译通过，运行不通过，Consumer实例不能转型成Producer类型
        Producer producer = (Producer) obj;

        // 编译通过，运行不通过，向下转型之前没有先进行向上转型
        Consumer consumer3 = (Consumer) new User();

        // 编译不通过，Producer实例不能转型成Consumer类型
        // Consumer consumer4 = (Consumer) new Producer();
    }
}

