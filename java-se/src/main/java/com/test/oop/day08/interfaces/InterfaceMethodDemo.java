package com.test.oop.day08.interfaces;

/**
 * 接口中的方法
 * （1）默认方法：当接口需要提供新的功能，方法需要在接口中定义。但是所有子类必须要覆写接口中的抽象方法。
 * 这种情况下将导致子类修改的复杂性。因此在接口中提供默认方法来统一为所有子类实现相同的能力。
 * （2）静态方法：当接口需要提供一些通用能力的时候，一般通过接口工具类的方式，比如Collection对应的工具类Collections。
 * JDK8之后可以直接将工具类的能力，在接口中进行定义。
 * （3）私有方法：接口中多个默认方法或静态方法存在重复代码，需要抽取，但是抽取的方法不希望被外部直接访问。
 * 私有方法包括私有默认方法和私有静态方法。JDK9之后开始支持私有方法。
 */
interface SuperInterfaceA {
    // 接口中的静态方法，归属类，只能通过接口名调用
    // 和SuperInterfaceB接口中的方法重名
    public static void staticMethod() {
        System.out.println("SuperInterfaceA.staticMethod");
    }

    // 接口中的默认方法，归属实例，可以被实现类继承，通过对象进行调用
    // 和SuperInterfaceB接口中方法重名
    public default void defaultMethod() {
        System.out.println("SuperInterfaceA.defaultMethod");
    }

    // 接口中的方法默认权限就是public
    // 和SuperClass类中的方法重名
    default void defaultMethod2() {
        System.out.println("SuperInterfaceA.defaultMethod2");
    }

    // 不重名的方法
    public default void defaultMethod3() {
        System.out.println("SuperInterfaceA.defaultMethod3");
    }
}

interface SuperInterfaceB {
    // 和接口SuperInterfaceA中的方法重名
    public static void staticMethod() {
        System.out.println("SuperInterfaceB.staticMethod");
    }

    // 和接口SuperInterfaceA中的方法重名
    public default void defaultMethod() {
        System.out.println("SuperInterfaceB.defaultMethod");
    }
}

class SuperClass {
    // 和接口SuperInterfaceA中的方法重名
    public void defaultMethod2() {
        System.out.println("SuperClass.defaultMethod2");
    }
}

/**
 * 子类继承父类，并实现多个接口
 * （1）实现的多个接口中方法重名，子类需要覆写方法
 * （2）继承的类和实现的接口中方法重名，不要求子类覆写方法，调用的是继承类中的方法
 */
class SubClass extends SuperClass implements SuperInterfaceA, SuperInterfaceB {
    /**
     * 实现的接口中存在重名的方法时，需要覆写接口中的方法，否则编译错误
     */
    @Override
    public void defaultMethod() {
        // 子类中通过"父接口.super"的方法调用父接口的方法
        SuperInterfaceA.super.defaultMethod();
        SuperInterfaceB.super.defaultMethod();
        System.out.println("SubClass.defaultMethod");
    }

    public void test() {
        /*
            接口中的default方法需要通过实例化对象调用
            当子类继承父类并实现接口时，使用"super.方法名()"只会从父类中查找方法，不会从父接口中查找default方法
            调用接口中重名的default方法需要使用"接口名称.super.方法名()"的格式
         */
        // 父类中的方法
        defaultMethod2(); // SuperClass.defaultMethod2

        // 父接口中的方法
        SuperInterfaceA.super.defaultMethod2(); // SuperInterfaceA.defaultMethod2

        // 直接从父接口继承，不重名，无需指定
        defaultMethod3(); // SuperInterfaceA.defaultMethod3
        SuperInterfaceA.super.defaultMethod3(); // SuperInterfaceA.defaultMethod3
    }
}

/**
 * 接口中默认方法和静态方法
 * 子类继承父类实现接口时方法冲突解决
 */
public class InterfaceMethodDemo {
    public static void main(String[] args) {
        System.out.println("==========接口中的静态方法只能通过接口名调用==========");
        // 接口中static方法重名无影响，static方法只能通过接口名调用
        SuperInterfaceA.staticMethod(); // SuperInterfaceA.staticMethod
        SuperInterfaceB.staticMethod(); // SuperInterfaceB.staticMethod

        System.out.println("==========子类覆写接口中的重名方法==========");
        /*
            SuperInterfaceA.defaultMethod
            SuperInterfaceB.defaultMethod
            SubClass.defaultMethod
         */
        // 子类实现的多个父接口，接口中存在重名的实现方法，子类必须要覆写该方法
        SubClass sub = new SubClass();
        sub.defaultMethod();

        System.out.println("==========父类和父接口中存在重名的实现方法==========");
        // 子类继承父类，实现接口，父类和接口中存在重名的实现方法，优先调用父类的方法
        sub.test();
    }
}
