package com.test.day06.task;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LogTask {

    /**
     * 定义定时任务执行的方式，就是一个普通方法
     */
    public void run() {
        System.out.println(LocalDateTime.now() + " " + LogTask.class.getName());
    }
}
