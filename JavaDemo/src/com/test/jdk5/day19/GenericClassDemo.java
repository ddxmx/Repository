package com.test.jdk5.day19;

/**
 * 泛型类
 * 可以有多个泛型参数类型，比如<E1,E2,E3>
 */
class Info<T> { // 泛型标识任意，常用的泛型标识：T(Type)、E(Element)、K(Key)、V(Value)
    private T msg;

    public Info(T msg) {
        this.msg = msg;
    }

    public T getMsg() {
        return this.msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}

/**
 * 泛型类
 */
public class GenericClassDemo {
    public static void main(String[] args) {
        /*
            泛型类型只能是引用数据类型，不能是基本数据类型
            调用泛型类中的构造方法或普通方法时，参数需要和泛型类型一致
            泛型类使用时不一定必须要传入泛型类型，不传入时，类型默认为Object
         */
        Info<String> info = new Info<>("hello");
        String msg = info.getMsg();
        System.out.println(msg); // hello

        Info<Integer> info2 = new Info<>(123);
        Integer msg2 = info2.getMsg();
        System.out.println(msg2); // 123

        Info info3 = new Info("world");
        // String msg3 = info3.getMsg(); // 编译错误，只能使用Object接收
        Object msg3 = info3.getMsg();
        System.out.println(msg3); // world
    }
}
