package com.test.jdk5.day16.generic.basic;

/**
 * 泛型类
 * 可以有多个泛型参数类型，比如<E1,E2,E3>
 */
class Message<T> { // 泛型标识任意，常用的泛型标识：T(Type)、E(Element)、K(Key)、V(Value)
    private T msg;

    public Message(T msg) {
        this.msg = msg;
    }

    public T getMsg() {
        return this.msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    // 编译错误，泛型类中的泛型参数的实例化是在定义泛型类型对象的时候指定的，而静态变量和静态方法不需要使用对象来调用
    // public static void func(T msg) {}
}

public class GenericClassDemo {
    public static void main(String[] args) {
        /*
            泛型类型只能是引用数据类型，不能是基本数据类型
            调用泛型类中的构造方法或普通方法时，参数需要和泛型类型一致
            泛型类使用时不一定必须要传入泛型类型，不传入时，类型默认为Object
         */
        Message<String> info = new Message<>("hello");
        String msg = info.getMsg();
        System.out.println(msg); // hello

        Message<Integer> info2 = new Message<>(123);
        Integer msg2 = info2.getMsg();
        System.out.println(msg2); // 123

        Message info3 = new Message("world");
        // String msg3 = info3.getMsg(); // 编译错误，只能使用Object接收
        Object msg3 = info3.getMsg();
        System.out.println(msg3); // world
    }
}
