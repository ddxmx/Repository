package com.test.day06.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class TaskConfig {
    @Bean
    public MonitorTask monitorTask() {
        return new MonitorTask();
    }
}
