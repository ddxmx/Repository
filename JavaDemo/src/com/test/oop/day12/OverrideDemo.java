package com.test.oop.day12;

class Bird {
    public void fly() {
        System.out.println("鸟儿在天空自由自在的飞翔~");
    }

    public void sleep() {
        System.out.println("鸟儿栖息在树上睡觉~");
    }

    private void talk() {
        System.out.println("我是一只小鸟~");
    }

    public void show() {
        this.talk();
    }

    //static方法是不能被覆写的，static方法调用者是类，而不是对象
    public static void eat() {
        System.out.println("Bird eat");
    }

    public static void test() {
        eat();
    }
}

/**
 * 子类继承父类后，可以对父类中的方法进行重写
 * <p>
 * 重载和重写的区别：
 * 1、方法的重载和重写都是实现多态的方式，区别在于重载是编译时的多态性，而重写是运行时的多态性。
 * 2、重载发生在一个类中，方法名称相同，参数的类型或个数不同；重写发生在父子类之间，子类和父类有相同的方法名称、参数列表，
 * 3、重写要求子类访问权限>=父类，
 * 子类返回值<=父类返回值，父类是void，子类也是void;父类是引用数据类型，子类可以是其子类；父类是基本数据类型，子类也必须是相同的基本数据类型
 * 子类抛出异常类型<=父类异常类型
 * 重载没有以上要求
 */
class Ostrich extends Bird {
    //重写的方法和父类方法的方法名、参数类型要完全一致
    @Override
    public void fly() {
        System.out.println("鸵鸟在地上奔跑~");
    }

    //void sleep(){} //编译失败，缩小了访问权限修饰符

    //父类是private类型，子类无法覆写，只是定义了一个重名的方法
    public void talk() {
        System.out.println("我是鸵鸟~");
    }

    public static void eat() {
        System.out.println("Ostrich eat");
    }
}

public class OverrideDemo {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly(); //鸟儿在天空自由自在的飞翔~

        Ostrich ostrich = new Ostrich();
        ostrich.fly(); //鸵鸟在地上奔跑~

        ostrich.sleep(); //鸟儿栖息在树上睡觉~

        //方法没有覆写，调用的是父类的方法，而不是子类的方法
        ostrich.show(); //我是一只小鸟~

        ostrich.test(); //Bird eat，static方法不会被覆写，就近原则，始终调用的父类中的eat方法
    }
}
