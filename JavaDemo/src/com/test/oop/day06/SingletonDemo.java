package com.test.oop.day06;

/**
 * 饿汉式，线程安全，推荐方式
 * 实现方式：
 * |- 将类中构造方法私有化
 * |- 在类中只实例化一个类对象
 * |- 通过static的方法提供实例对象的获取
 */
class Singleton {
    // static修饰，保证全局唯一
    private static final Singleton INSTANCE = new Singleton();

    /**
     * 单例模式，需要将构造方法私有化，只允许在类中实例化
     */
    private Singleton() {
    }

    /**
     * 提供方法获取实例化对象
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }

    public void action() {
        System.out.println("Singleton.action");
    }
}

/**
 * 懒汉式，非线程安全，需要进行线程安全处理
 */
class SingletonLazy {
    private static SingletonLazy instance;

    private static Object lock = new Object();

    private SingletonLazy() {
    }

    /**
     * 获取实例化对象时才进行对象的创建，可能存在线程安全的问题
     * 解决线程安全的问题，可以采用同步方式
     */
    public static SingletonLazy getInstance() {
        // 不在外层加锁，为了效率，防止每个请求都进行同步等待
        if (null == instance) {
            synchronized (lock) {
                // 同步代码块中再次判断，防止多个并发请求时，重复创建对象
                if (null == instance) {
                    instance = new SingletonLazy();
                    System.out.println("创建了实例化对象...");
                }
            }
        }

        return instance;
    }

    public void action() {
        System.out.println("SingletonLazy.action");
    }
}

/**
 * 单例设计模式：整个JVM运行期间，类的实例化对象只有一个。实现方式分为饿汉式和懒汉式
 * java.lang.Runtime类就是使用的单例模式
 * 饿汉式：类加载的时候对象就创建；线程安全的
 * 懒汉式(懒加载)：获取对象时才创建，非线程安全的
 */
public class SingletonDemo {
    public static void main(String[] args) {
        SingletonLazy instanceA = SingletonLazy.getInstance();
        SingletonLazy instanceB = SingletonLazy.getInstance();
        SingletonLazy instanceC = SingletonLazy.getInstance();

        System.out.println(instanceA == instanceB); // true
        System.out.println(instanceA == instanceC); // true

        instanceA.action(); // SingletonLazy.action
    }
}
