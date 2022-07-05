package com.test.oop.day10;

/**
 * 内部类：在类的内部声明另外一个类，外部的称为外部类，内部的称为内部类
 * 分为成员内部类（静态内部类、非静态内部类）、局部内部类、匿名内部类
 */
class Outer {
    // 外部类中的private属性
    private int value = 10;

    // 外部类中的static属性
    private static String msg = "hello world";

    /**
     * 成员内部类
     * 内部类如果只想在外部类中使用，可以使用private修饰内部类
     */
    /*private*/ class Inner {
        // 内部类中的private属性
        private int number = 10;

        // 内部类中和外部类重名的private属性
        private int value = 20;

        /**
         * 内部类方法
         */
        public void printInfo() {
            System.out.println(number); // 10
            // 就近原则，访问内部类中的value属性
            System.out.println(value); // 20
            // 在内部类中访问外部类中同名的属性，使用"外部类.this.属性名"的形式
            System.out.println(Outer.this.value); // 10
        }
    }

    public void test() {
        // 实例化内部类对象
        Inner inner = new Inner();
        // 外部类可以通过内部类对象，直接访问内部类私有成员
        System.out.println(inner.number); // 10
        System.out.println(inner.value); // 20
        inner.printInfo();
    }

    /**
     * 静态成员内部类
     * 静态成员内部类实例化，不依赖外部类的实例化对象
     */
    static class Inner2 {
        private int number2 = 20;

        public void printInfo() {
            System.out.println(number2); // 20
            // 编译错误，静态内部类不能访问外部类中的非静态成员
            // System.out.println(Outer.this.value);
            System.out.println(Outer.msg); // hello world
        }
    }

    /**
     * 在方法内定义内部类，方法调用结束后方法会被销毁，但是内部类对象需要继续使用
     * 因此为了保证内部类的正常使用，方法中内部类中如果使用了方法的参数或局部变量，方法的参数或局部变量需要声明为final
     * JDK8后final可以省略
     */
    public void test(final int var1) {
        final int var2 = 100;

        // 变量没有在内部类中使用，则变量不会使用final修饰，可以修改
        int var3 = 200;
        var3 = 220;
        System.out.println(var3); // 220

        /**
         * 局部内部类
         * 只能在方法中实例化
         */
        class Inner3 {
            private int value = 99;

            public void printInfo() {
                // 编译失败，内部类中使用方法的参数或局部变量，参数和局部变量都是使用final修饰的，无法修改
                // var1 = 10;
                // var2 = 20;
                // 修改内部类中的成员变量
                value = 30;
                // 修改外部类中的成员变量
                Outer.this.value = 40;
                System.out.println(var1); // 50
                System.out.println(var2); // 100
                System.out.println(value); // 30
                System.out.println(Outer.this.value); // 40
            }
        }

        new Inner3().printInfo();
    }
}


public class InnerClassDemo {
    public static void main(String[] args) {
        System.out.println("========非静态内部类，在外部类中实例化========");
        Outer outer = new Outer();
        outer.test();

        System.out.println("========非静态内部类，在外部类之外实例化========");
        // 内部类对象的实例化，依赖外部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.printInfo();

        System.out.println("========静态内部类========");
        // 静态内部类，实例化内部类对象不依赖外部类对象
        Outer.Inner2 inner2 = new Outer.Inner2();
        inner2.printInfo();

        System.out.println("========局部内部类========");
        // 局部内部类
        Outer outer2 = new Outer();
        outer2.test(50);

        System.out.println("========匿名内部类========");
        // 匿名内部类，只使用一次，一般用于对象传参
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程运行");
            }
        }).start();
    }
}
