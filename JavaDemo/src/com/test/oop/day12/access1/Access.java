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
        //不涉及到子类的概念，缺省的属性必然要通过创建对象访问
        System.out.println(access.defaultVar);
        access.defaultMethod();
    }
}
