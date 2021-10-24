package com.test.api.day21;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Runtime是单例模式，只有一个实例
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        // 实例化
        Runtime runtime = Runtime.getRuntime();

        // GC，System.gc()方法实际调用的也是Runtime.getRuntime().gc()
        runtime.gc();

        // 获取CPU个数
        int processors = runtime.availableProcessors();
        System.out.println(processors); // 6

        // 最大可用内存
        System.out.println(runtime.maxMemory());
        // 当前分配总内存
        System.out.println(runtime.totalMemory());
        // 当前分配后空闲内存
        System.out.println(runtime.freeMemory());

        // 执行系统命令
        try {
            Process process = runtime.exec("notepad");
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
