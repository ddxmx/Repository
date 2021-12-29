package com.test.api.day15;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Runtime是单例模式，JVM中只有一个实例化对象
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        // 获取实例化对象
        Runtime runtime = Runtime.getRuntime();

        // 多次获取的runtime是同一个实例
        System.out.println(Runtime.getRuntime() == Runtime.getRuntime()); // true

        // 建议GC，System.gc()方法实际调用的也是Runtime.getRuntime().gc()
        runtime.gc();

        // 获取CPU个数
        int processors = runtime.availableProcessors();
        System.out.println(processors); // 6

        // Java虚拟机尝试使用的最大内存量
        System.out.println(runtime.maxMemory());
        // Java虚拟机中的内存总量
        System.out.println(runtime.totalMemory());
        // Java虚拟机中的可用内存量
        System.out.println(runtime.freeMemory());

        // 执行系统命令
        try {
            Process process = runtime.exec("notepad.exe");
            TimeUnit.SECONDS.sleep(5);
            // 销毁进程
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
