package com.test.basic.day06.task;

import java.time.LocalDateTime;

public class LogTask {
    /**
     * 定义定时任务执行的方式，就是一个普通方法
     */
    public void run() {
        System.out.println(LocalDateTime.now() + " " + LogTask.class.getName());
    }
}
