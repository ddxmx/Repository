package com.test.day13;

/**
 * Object其他非常用方法使用
 * clone方法的类必须要实现java.lang.Cloneable接口，该接口中无任何抽象方法，只是表示一种能力
 */
class Customer implements Cloneable {
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    /**
     * 永远不用手动去覆写该方法
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Customer对象被回收...");
    }
}

public class ObjectDemo02 {
    public static void main(String[] args) throws Exception {
        Customer c1 = new Customer("Tom", 12);
        Customer c2 = c1.clone();
        System.out.println(c1 == c2); //false

        c1.setAge(10);
        System.out.println(c1.getAge()); //10
        System.out.println(c2.getAge()); //12

        c2 = null; //对象没有栈内存空间指向，就称为垃圾
        //使用Runtime类或System类的gc()方法建议GC进行垃圾回收，但是不一定会进行回收，程序无法精确控制垃圾回收的时间
        //Runtime.getRuntime().gc();
        System.gc(); //Customer对象被回收...
    }
}
