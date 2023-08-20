package com.test.oop.day09.inner;

/**
 * 內部类是为了方便类之间私有成员的访问
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

        // 编译失败，非静态内部类不能定义静态成员
        // static属性不依赖实例化对象，如果内部类不是静态的，那么将依赖外部类的实例，导致外部类实例成员优先于内部类的静态成员初始化
        // private static String info = "hello";

        /**
         * 内部类方法
         * 定义为private，用于演示外部类可以方便调用内部类的private方法
         */
        private void printInfo() {
            System.out.println(number);
            // 就近原则，访问内部类中的value属性
            System.out.println(value);
            // 在内部类中访问外部类中同名的属性，使用"外部类.this.属性名"的形式
            System.out.println(Outer.this.value);
        }

        public void print() {
            printInfo();
        }
    }

    /**
     * 外部类方法
     */
    public void test() {
        // 实例化内部类对象
        Inner inner = new Inner();
        // 外部类可以通过内部类对象，直接访问内部类私有成员
        System.out.println(inner.number);
        System.out.println(inner.value);
        inner.printInfo();
    }

    /**
     * 外部类中静态私有方法
     */
    private static void printMsg() {
        System.out.println(msg);
    }

    /**
     * 静态成员内部类
     * 静态成员内部类实例化，不依赖外部类的实例化对象
     */
    static class InnerStatic {
        private int number = 20;

        public void printInfo() {
            System.out.println(number);

            // 编译错误，静态内部类不能访问外部类中的非静态成员
            // System.out.println(Outer.this.value);

            // 静态内部类可以直接访问外部类的静态成员
            System.out.println(msg);
            printMsg();
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
        int var3 = 110;
        var3 = 120;
        System.out.println(var3);

        /**
         * 局部内部类
         * 只能在方法中实例化
         */
        class InnerLocal {
            private int value = 50;

            public void printInfo() {
                // 编译错误，内部类中使用方法的参数或局部变量，参数和局部变量都是使用final修饰的，无法修改
                // var1 = 10;
                // var2 = 20;

                // 修改内部类中的成员变量
                value = 30;
                // 修改外部类中的成员变量
                Outer.this.value = 40;

                System.out.println(var1);
                System.out.println(var2);
                System.out.println(value);
                System.out.println(Outer.this.value);
            }
        }

        // 实例化局部内部类对象，并调用方法
        new InnerLocal().printInfo();
    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
        System.out.println("================非静态内部类，在外部类中实例化================");
        /*
            10
            20
            10
            20
            10
         */
        new Outer().test();

        System.out.println("================非静态内部类，在外部类之外实例化================");
        /*
            10
            20
            10
         */
        // 内部类对象的实例化，依赖外部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.print();

        System.out.println("================静态内部类================");
        /*
            20
            hello world
            hello world
         */
        // 静态内部类，实例化内部类对象不依赖外部类对象
        Outer.InnerStatic innerStatic = new Outer.InnerStatic();
        innerStatic.printInfo();

        System.out.println("================局部内部类================");
        /*
            120
            50
            100
            30
            40
         */
        new Outer().test(50);

        System.out.println("================匿名内部类================");
        // 匿名内部类，只使用一次，一般用于对象传参
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        thread.start();
    }
}
