package com.test.day06.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MonitorTask {

    @Scheduled(cron = "10-15 * * * * ?")
    public void show() {
        if (System.currentTimeMillis() / 1000 % 5 == 0) {
            System.out.println(LocalDateTime.now() + " 到达一个监控周期~");
        } else {
            System.out.println(LocalDateTime.now() + " 监控窗口中...");
        }
    }

}
