package com.test.oop.day08;

class Bird {
    public void fly() {
        System.out.println("Bird.fly");
    }

    public void sleep() {
        System.out.println("Bird.sleep");
    }

    // private访问权限的方法，无法被子类覆写
    private void talk() {
        System.out.println("Bird.talk");
    }

    public void doTalk() {
        this.talk();
    }

    // static方法是不能被覆写的，static方法调用者是类，而不是对象
    public static void eat() {
        System.out.println("Bird.eat");
    }

    public static void doEat() {
        eat();
    }
}

/**
 * 子类继承父类后，可以对父类中的方法进行覆写
 * 重载和覆写的区别：
 * |- 方法的重载和覆写都是实现多态的方式，区别在于重载是编译时的多态性，而覆写是运行时的多态性
 * |- 重载发生在一个类中，方法名称相同，参数的类型或个数不同；覆写发生在父子类之间，子类和父类有相同的方法名称、参数列表
 * |- 覆写要求子类访问权限>=父类，子类返回值<=父类返回值，父类是void，子类也是void
 *    父类返回值是引用数据类型，子类可以是其子类；父类返回值是基本数据类型，子类也必须是相同的基本数据类型，重载没有此要求
 * |- 覆写要求子类抛出的异常类型<=父类抛出的异常类型，重载没有此要求
 */
class Ostrich extends Bird {
    // 覆写的方法和父类方法的方法名、参数类型要完全一致
    @Override
    public void fly() {
        System.out.println("Ostrich.fly");
    }

    // 编译失败，继承是is-a的关系，子类必须支持父类的所有对外行为，因此覆写不允许缩小访问权限
    // void sleep(){}

    // 定义了和父类重名的方法，非方法覆写
    // @Override
    public void talk() {
        System.out.println("Ostrich.talk");
    }

    // 定义了和父类重名的方法，非方法覆写
    public static void eat() {
        System.out.println("Ostrich.eat");
    }
}

public class OverrideDemo {
    public static void main(String[] args) {
        // 实例化父类对象
        Bird bird = new Bird();
        bird.fly(); // Bird.fly

        // 实例化子类对象
        Ostrich ostrich = new Ostrich();
        // 调用子类覆写的方法
        ostrich.fly(); // Ostrich.fly

        // 调用从父类继承的方法
        ostrich.sleep(); // Bird.sleep

        // talk()方法没有被覆写，就近原则，调用的是父类的方法，而不是子类的方法
        ostrich.doTalk(); // Bird.talk

        // 方法没有覆写，就近原则，调用的是父类的方法，而不是子类的方法
        ostrich.doEat(); // Bird.eat
    }
}
