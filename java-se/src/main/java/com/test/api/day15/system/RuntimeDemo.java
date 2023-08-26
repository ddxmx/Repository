package com.test.api.day15.system;

/**
 * Runtime是单例模式，JVM中只有一个实例化对象
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        // 获取实例化对象
        Runtime runtime = Runtime.getRuntime();

        // 多次获取的runtime是同一个实例
        System.out.println(Runtime.getRuntime() == Runtime.getRuntime()); // true

        // 建议GC，JVM并不一定会真的执行GC
        // System.gc()方法实际调用的也是Runtime.getRuntime().gc()
        runtime.gc();

        // 获取CPU个数
        int processors = runtime.availableProcessors();
        System.out.println(processors); // 6

        // Java虚拟机尝试使用的最大内存量，JVM最大分配的堆内存由-Xmx指定，默认是物理内存的1/4
        System.out.println(runtime.maxMemory());
        // Java虚拟机中的内存总量，JVM已占用的内存大小，-Xms指的是totalMemory的初始值，默认是物理内存的1/64
        System.out.println(runtime.totalMemory());
        // Java虚拟机中的可用内存量
        System.out.println(runtime.freeMemory());

        // 执行系统命令
        Process process = null;
        try {
            process = runtime.exec("notepad.exe");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != process) {
                // 销毁进程
                process.destroy();
            }
        }
    }
}
