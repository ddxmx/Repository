package com.test.day15;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

class Outer {
    private int value = 10;

    private static String msg = "hello world";

    /**
     * 成员内部类
     */
    /*private*/ class Inner {
        private int number = 10;
        private int value = 20;

        public void info() {
            System.out.println(number);
            System.out.println(value);
            //在内部类中访问外部类中同名的属性
            System.out.println(Outer.this.value);
        }
    }

    public void test1() {
        Inner inner = new Inner();
        //外部类可以通过内部类对象，直接调用内部类私有成员
        System.out.println(inner.number);
        System.out.println(inner.value);
        System.out.println("***************************");
        inner.info();
    }

    /**
     * 静态成员内部类
     */
    static class Inner2 {
        private int number2 = 20;

        public void message() {
            System.out.println(number2);
            //System.out.println(Outer.this.value); //静态内部类，不能访问外部类中的非静态成员
            System.out.println(Outer.msg);
        }
    }

    /**
     * 内部类的生命周期要长于方法
     * 因此为了保证内部类的正常使用，方法内的变量需要使用final修饰入常量池
     *
     * @param var1
     */
    public void test3(int var1) {
        int var2 = 200;
        /**
         * 局部内部类
         */
        class Inner3 {
            private int value = 99;

            public void print() {
                //var1 = 10; //方法的参数默认是final修饰的
                //var2 = 20; //方法中的局部变量也是final修饰的
                value = 30;
                Outer.this.value = 40;
                System.out.println(var1);
                System.out.println(var2);
                System.out.println(value);
                System.out.println(Outer.this.value);
            }
        }

        new Inner3().print();
    }
}

/**
 * 内部类：在类的内部声明另外一个类，外部的称为外部类，内部的称为内部类
 * 分为成员内部类（静态的、非静态的）、局部内部类
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        /*
            10
            20
            ***************************
            10
            20
            10
         */
        outer.test1();

        System.out.println("==================================");
        //在类外部实例化内部类
        Outer.Inner inner = new Outer().new Inner();
        /*
            10
            20
            10
         */
        inner.info();

        System.out.println("==================================");
        Outer.Inner2 inner2 = new Outer.Inner2();
        /*
            20
            hello world
         */
        inner2.message();

        System.out.println("==================================");
        Outer outer3 = new Outer();
        /*
            100
            200
            30
            40
         */
        outer3.test3(100);

        System.out.println("==================================");
        /*
            匿名内部类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(LocalDateTime.now() + " 线程主体");
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
