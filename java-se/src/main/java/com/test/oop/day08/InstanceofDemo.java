package com.test.oop.day08;

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

/**
 * 向下转型
 * 使用instanceof进行安全转型的判断
 * a instanceof A：对象a是否是类A的实例
 */
public class InstanceofDemo {
    public static void main(String[] args) {
        // 向上转型
        User user1 = new Consumer();
        user1.sleep(); // Consumer.sleep
        user1.eat(); // Consumer.eat
        // 编译失败，user1是User类型，其中没有定义consume方法，方法是否可以被调用取决于声明类型
        // user1.consume();

        // 向下转型，向下转型之前必须要先进行向上转型，否则会出现ClassCastException异常
        Consumer consumer = (Consumer) user1;
        // Consumer类中定义了consume方法，因此可以正常调用
        consumer.consume(); // Consumer.consume

        System.out.println("****************************************");
        // 向上转型
        User user2 = new Producer();
        // 编译成功，运行失败，java.lang.ClassCastException: Producer cannot be cast to Consumer
        // Consumer consumer2 = (Consumer) user2;

        // 为了避免向下转型出现异常，在向下转型前使用instanceof判断对象是否是类的实例
        if (user2 instanceof Consumer) {
            ((Consumer) user2).consume();
        }
        if (user2 instanceof Producer) {
            ((Producer) user2).produce(); // Producer.produce
        }

        System.out.println(user2 instanceof User); // true
        System.out.println(user2 instanceof Consumer); // false
        System.out.println(user2 instanceof Producer); // true

        System.out.println("****************************************");
        Object obj = new Consumer();
        // 编译运行都通过
        User user3 = (User) obj;

        // 编译通过，运行不通过
        // Consumer consumer3 = (Consumer) new User();

        // 编译不通过，Producer类型和Consumer类型之间没有父子关系，不能强转
        // Consumer consumer4 = (Consumer) new Producer();

        Object obj5 = new Consumer();
        // 编译通过，运行不通过，Producer类型和Consumer类型之间没有父子关系，不能强转
        // Producer producer = (Producer) obj5;
    }
}
