package com.test.bean;

import com.test.annotation.Dept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeptConfig {
    @Bean
    public Dept dept() {
        Dept dept = new Dept();
        dept.setName("纽约");
        return dept;
    }
}
