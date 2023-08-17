package com.test.oop.day06.initialize;

/**
 * 单例设计模式：整个JVM运行期间，类的实例化对象只有一个。java.lang.Runtime类就是使用的单例模式
 * 1、单例设计模式实现分为饿汉式和懒汉式
 * 饿汉式：类加载的时候对象就创建；线程安全的，推荐使用
 * 懒汉式(懒加载)：获取对象时才创建，非线程安全的
 * 2、单例模式实现方式：
 * （1）将类中构造方法私有化
 * （2）在类中只创建一个实例
 * （3）通过static方法提供实例的获取
 * 3、构造方法私有化主要有三种场景
 * （1）类不需要实例化，只提供static方法，如Arrays类，Math类等
 * （2）单例设计模式，只允许生成一个实例
 * （3）提取构造器公共代码，消除重复
 */
class Singleton {
    // 在类内部实例化对象，只能类中的static方法访问
    private static final Singleton INSTANCE = new Singleton();

    /**
     * 单例模式，需要将构造方法私有化，只允许在类中实例化
     */
    private Singleton() {
    }

    /**
     * 提供方法在类外部获取实例化对象
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
        // 为了提升性能，不在外层加锁，防止实例化结束后方法每次调用仍进行同步等待
        if (null == instance) {
            synchronized (lock) {
                // 同步代码块中再次判断，防止并发操作时，重复创建对象
                if (null == instance) {
                    instance = new SingletonLazy();
                }
            }
        }

        return instance;
    }

    public void action() {
        System.out.println("SingletonLazy.action");
    }
}

public class ConstructorPrivateDemo {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        s1.action(); // SingletonLazy.action

        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1 == s2); // true
    }
}
