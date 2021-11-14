package com.test.oop.day11;

/**
 * 默认方法支持的原因：当接口中需要提供新的功能，方法需要在接口中定义。但是所有子类必须要覆写接口中的抽象方法。
 * 这种情况下将导致子类修改的复杂性。因此在接口中提供默认方法来统一为所有子类实现相同的能力。
 * <p>
 * 静态方法支持的原因：当接口需要提供一些通用能力的时候，一般通过接口工具类的方式，比如Collection对应的工具类Collections。
 * JDK8之后可以直接将工具类的能力，在接口中进行定义。
 * <p>
 * 私有方法支持的原因：接口中多个默认方法或静态方法存在重复代码，需要抽取，但是抽取的方法不希望直接被外部直接访问。
 * 私有方法包括私有默认方法和私有静态方法。JDK9之后开始支持私有方法。
 */
interface SuperInterfaceA {
    // 接口中的静态方法，只能通过接口名调用
    public static void staticMethod() {
        System.out.println("SuperInterfaceA.staticMethod");
    }

    // 接口中的默认方法，可以被实现类继承
    public default void defaultMethod() {
        System.out.println("SuperInterfaceA.defaultMethod");
    }

    // 接口中的方法默认权限就是public
    default void defaultMethod2() {
        System.out.println("SuperInterfaceA.defaultMethod2");
    }

    public default void defaultMethod3() {
        System.out.println("SuperInterfaceA.defaultMethod3");
    }

    public default void defaultMethod4() {
        System.out.println("SuperInterfaceA.defaultMethod4");
    }
}

interface SuperInterfaceB {
    // 和接口SuperInterfaceA中的方法重名
    public default void defaultMethod() {
        System.out.println("SuperInterfaceB.defaultMethod");
    }
}

class SuperClass {
    // 和接口SuperInterfaceA中的方法重名
    public void defaultMethod3() {
        System.out.println("SuperClass.defaultMethod3");
    }
}

/**
 * 子类继承父类，并实现多个接口
 */
class SubClass extends SuperClass implements SuperInterfaceA, SuperInterfaceB {
    /**
     * 实现的接口中存在重名的方法时，需要覆写接口中的方法，否则编译失败
     */
    @Override
    public void defaultMethod() {
        System.out.println("SubClass.defaultMethod");
    }

    // 子类可以覆写接口中的default方法
    @Override
    public void defaultMethod2() {
        System.out.println("SubClass.defaultMethod2");
    }

    public void invoke() {
        /*
            接口中的default方法需要通过实例化对象调用
            当子类继承父类，并实现接口时，使用super.方法名()只会从父类中查找方法，不会从父接口中查找default方法
            调用接口中的默认方法需要使用接口名称.super.方法名()的格式
         */
        // SuperInterfaceA
        SuperInterfaceA.super.defaultMethod();
        SuperInterfaceA.super.defaultMethod2();
        SuperInterfaceA.super.defaultMethod3();
        // 直接从父接口继承，无需指定
        defaultMethod4();

        System.out.println("---------------------------------------");
        SuperInterfaceB.super.defaultMethod();

        System.out.println("---------------------------------------");
        super.defaultMethod3();
    }
}

/**
 * 接口中默认方法和静态方法
 * 子类继承父类实现接口时方法冲突解决
 */
public class InterfaceMethodDemo {
    public static void main(String[] args) {
        SubClass instance = new SubClass();
        // 接口中的静态方法只能通过接口名调用
        SuperInterfaceA.staticMethod(); // SuperInterfaceA.staticMethod
        // 调用子类覆写的方法
        instance.defaultMethod(); // SubClass.defaultMethod
        // 调用子类覆写的方法
        instance.defaultMethod2(); // SubClass.defaultMethod2
        /*
            子类继承父类，实现接口，父类和接口中存在重名的实现方法，优先调用父类的方法
         */
        instance.defaultMethod3(); // SuperClass.defaultMethod3

        System.out.println("********************************");
        /*
            SuperInterfaceA.defaultMethod
            SuperInterfaceA.defaultMethod2
            SuperInterfaceA.defaultMethod3
            SuperInterfaceA.defaultMethod4
            ---------------------------------------
            SuperInterfaceB.defaultMethod
            ---------------------------------------
            SuperClass.defaultMethod3
         */
        instance.invoke();
    }
}
