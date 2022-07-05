package com.test.oop.day08.spel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//表示是一个配置类
@Configuration
//注解扫描位置
@ComponentScan("com.test.oop.day08.spel.el")
public class BeanConfig {
}
