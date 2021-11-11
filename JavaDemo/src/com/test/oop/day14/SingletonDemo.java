package com.test.oop.day14;

/**
 * 单例设计模式：饿汉式和懒汉式
 * 饿汉式：类加载的时候对象就创建；线程安全的
 * 懒汉式：(懒加载)，非线程安全的
 * java.lang.Runtime类就是使用的单例模式
 */
/*
class Singleton {
    // 饿汉式
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void show() {
        System.out.println("Singleton.show");
    }
}
*/

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    /**
     * 获取实例化对象时才进行对象的创建，可能存在线程安全的问题
     * 解决线程安全的问题，可以采用同步方式
     */
    public static Singleton getInstance() {
        // 懒汉式
        // 不在外层加锁，为了效率，防止每个请求都进行同步等待
        if (null == instance) {
            synchronized (Singleton.class) {
                // 同步代码块中再次判断，防止多个并发请求时，重复创建对象
                if (null == instance) {
                    instance = new Singleton();
                    System.out.println("创建了实例化对象...");
                }
            }
        }

        // if (null == instance) {
        //     try {
        //         TimeUnit.MILLISECONDS.sleep(10);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     instance = new Singleton();
        //     System.out.println("创建了实例化对象...");
        // }

        return instance;
    }

    public void show() {
        System.out.println("Singleton.show");
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instanceA = Singleton.getInstance();
        instanceA.show(); // Singleton.show
        Singleton instanceB = Singleton.getInstance();
        instanceB.show(); // Singleton.show
        System.out.println(instanceA == instanceB); // true

        // ExecutorService pool = Executors.newFixedThreadPool(10);
        // for (int i = 0; i < 20; i++) {
        //     pool.submit(() -> {
        //         Singleton.getInstance();
        //     });
        // }
        // pool.shutdown();
    }
}
