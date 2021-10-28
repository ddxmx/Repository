package com.test.jdk5.day25;

/**
 * 泛型接口
 *
 * @param <T>
 */
interface IMessage<T> {
    public void show(T msg);
}

/**
 * 子类实现泛型接口方式一：子类继续使用泛型
 *
 * @param <T>
 */
class MessageImpl<T> implements IMessage<T> {
    @Override
    public void show(T msg) {
        System.out.println(msg.getClass().getName());
    }
}

/**
 * 子类实现泛型接口方式二：子类不使用泛型
 */
class MessageImpl2 implements IMessage<Integer> {
    @Override
    public void show(Integer msg) {
        long sum = 0;
        for (int i = 1; i <= msg; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

/**
 * 泛型接口最典型的实现就是容器类List、Set、Map
 * List<String> list = new ArrayList<String>
 */
public class GenericInterfaceDemo {
    public static void main(String[] args) {
        /*
            泛型接口实现方式一使用
         */
        IMessage<String> msg = new MessageImpl<>();
        msg.show("hello"); //java.lang.String

        IMessage<Double> msg2 = new MessageImpl<>();
        msg2.show(12.34); //java.lang.Double

        /*
            泛型接口实现方式二使用
         */
        //声明时只能使用IMessage<Integer>接收
        IMessage<Integer> msg3 = new MessageImpl2();
        msg3.show(100); //5050

        //不使用泛型，直接使用接口名称接收
        IMessage msg4 = new MessageImpl2();
        msg4.show("hello"); //java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
    }
}
