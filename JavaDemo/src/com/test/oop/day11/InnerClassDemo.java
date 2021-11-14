package com.test.oop.day11;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 外部类
 */
class Outer {
    // 外部类中的private属性
    private int value = 10;

    // 外部类中的static属性
    private static String msg = "hello world";

    /**
     * 成员内部类
     */
    /*private*/ class Inner {
        // 内部类中的private属性
        private int number = 10;

        // 内部类中和外部类重名的private属性
        private int value = 20;

        // 内部类方法
        public void info() {
            System.out.println(number);
            // 就近原则，访问内部类中的value属性
            System.out.println(value);
            // 在内部类中访问外部类中同名的属性
            System.out.println(Outer.this.value);
        }
    }

    public void test() {
        Inner inner = new Inner();
        // 外部类可以通过内部类对象，直接访问内部类私有成员
        System.out.println(inner.number);
        System.out.println(inner.value);
        System.out.println("--------------------------------");
        inner.info();
    }

    /**
     * 静态成员内部类
     * 静态成员内部类实例化，不依赖外部类的实例化对象
     */
    static class Inner2 {
        private int number2 = 20;

        public void info() {
            System.out.println(number2);
            // 静态内部类，不能访问外部类中的非静态成员
            // System.out.println(Outer.this.value);
            System.out.println(Outer.msg);
        }
    }

    /**
     * 在方法内定义内部类，方法调用结束后方法会被销毁，但是内部类对象需要继续使用
     * 因此为了保证内部类的正常使用，内部类中如果使用了方法的参数或局部变量，方法的参数或局部变量需要声明为final
     * JDK8后方法参数被内部类使用时，final可以省略
     */
    public void show(final int var1) {
        final int var2 = 200;

        /**
         * 局部内部类
         */
        class Inner3 {
            private int value = 99;

            public void info() {
                // 编译失败，方法的参数默认是final修饰的
                // var1 = 10;
                // 编译失败，方法中的局部变量也是final修饰的
                // var2 = 20;
                value = 30;
                Outer.this.value = 40;
                System.out.println(var1);
                System.out.println(var2);
                System.out.println(value);
                System.out.println(Outer.this.value);
            }
        }

        new Inner3().info();
    }
}

/**
 * 内部类：在类的内部声明另外一个类，外部的称为外部类，内部的称为内部类
 * 分为成员内部类（静态的、非静态的）、局部内部类
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        // 非静态内部类，在外部类中实例化内部类对象
        Outer outer = new Outer();
        /*
            10
            20
            --------------------------------
            10
            20
            10
         */
        outer.test();

        System.out.println("==================================");
        // 非静态内部类，在外部类外实例化内部类对象
        Outer.Inner inner = new Outer().new Inner();
        /*
            10
            20
            10
         */
        inner.info();

        System.out.println("==================================");
        // 静态内部类，实例化内部类对象不依赖外部类对象
        Outer.Inner2 inner2 = new Outer.Inner2();
        /*
            20
            hello world
         */
        inner2.info();

        System.out.println("==================================");
        // 局部内部类
        Outer outer3 = new Outer();
        /*
            100
            200
            30
            40
         */
        outer3.show(100);

        System.out.println("==================================");
        // 匿名内部类，只使用一次，一般用于对象传参
        new Thread(()->{
            while (true){
                System.out.println(LocalDateTime.now());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
