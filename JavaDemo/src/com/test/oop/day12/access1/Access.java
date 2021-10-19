package com.test.oop.day12.access1;

/**
 * 验证protected的访问权限
 */
public class Access {
    protected int protectedVar;
    int defaultVar;

    protected void protectedMethod() {
        protectedVar = 100;
        System.out.println("protected method：" + protectedVar);
    }

    void defaultMethod() {
        defaultVar = 200;
        System.out.println("default method：" + defaultVar);
    }
}

class AccessDemo {
    public static void main(String[] args) {
        Access access = new Access();
        // default属性在同一个包中可以直接通过对象方法
        System.out.println(access.defaultVar); // 0
        access.defaultMethod(); // default method：200
    }
}
