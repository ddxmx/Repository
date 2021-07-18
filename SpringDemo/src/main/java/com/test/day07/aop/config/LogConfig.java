package com.test.day07.aop.config;

import com.test.day07.aop.aspect.LogAspect;
import com.test.day07.aop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class LogConfig {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
