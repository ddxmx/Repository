package com.test.oop.day15;

/**
 * 默认方法的存在意义：当接口中需要提供新的功能，方法需要在接口中定义。但是子类必须要覆写接口中的抽象方法。
 * 这种情况下将导致子类修改的困难。因此在接口中提供默认方法来统一为所有子类实现相同的能力。
 * <p>
 * 静态方法的意义：当接口需要提供一些通用能力的时候，一般通过接口工具类的方式，比如Collection对应的工具类Collections
 * JDK8之后可以直接将工具类的能力，在接口中进行定义。
 */
interface SuperCompare {
    //接口中的静态方法，只能通过接口名调用
    public static void method1() {
        System.out.println("SuperCompare method1");
    }

    //接口中的默认方法，可以被实现类继承
    public default void method2() {
        System.out.println("SuperCompare method2");
    }

    //接口中的方法默认权限就是public
    default void method3() {
        System.out.println("SuperCompare method3");
    }

    public default void method4() {
        System.out.println("SuperCompare method4");
    }

    public default void method5() {
        System.out.println("SuperCompare method5");
    }

    public default void method6() {
        System.out.println("SuperCompare method6");
    }
}

interface SuperCompareB {
    public default void method5() {
        System.out.println("SuperCompareB method5");
    }
}

class SuperClass {
    public void method4() {
        System.out.println("SuperClass method4");
    }
}

class SubSuperCompare extends SuperClass implements SuperCompare, SuperCompareB {
    //子类可以覆写接口中的default方法
    public void method3() {
        System.out.println("SubSuperCompare method3");
    }

    /**
     * 实现的接口中存在重名的方法时，需要覆写接口中的方法，否则编译失败
     */
    public void method5() {
        System.out.println("SubSuperCompare method5");
    }

    public void test() {
        /*
            调用接口中的默认方法使用 接口名称.super.方法名() 的格式
            super.方法名()只会从父类中查找方法，不会从父接口中查找default方法
         */
        SuperCompare.super.method3();
        SuperCompare.super.method4();
        SuperCompare.super.method5();
        SuperCompareB.super.method5();
        method6();
    }
}

public class InterfaceDefaultStaticDemo {
    public static void main(String[] args) {
        SubSuperCompare instance = new SubSuperCompare();
        SuperCompare.method1(); //SuperCompare method1
        instance.method2(); //SuperCompare method2
        instance.method3(); //SubSuperCompare method3
        /*
            类继承类，实现接口，父类和接口中存在重名的实现方法，优先调用父类的方法
         */
        instance.method4(); //SuperClass method4
        instance.method5(); //SubSuperCompare method5
        System.out.println("********************************");
        /*
            SuperCompare method3
            SuperCompare method4
            SuperCompare method5
            SuperCompareB method5
            SuperCompare method6
         */
        instance.test();
    }
}
