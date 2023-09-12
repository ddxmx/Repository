package com.test.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 不使用xml方式配置包扫描路径，直接使用注解方式
 * 1、bean配置的推荐顺序：bean注解自动发现 > java配置注册bean > xml配置
 * 2、java配置类，@Configuration等同于xml中的<beans></beans>标签
 * 3、使用@ComponentScan扫描包有两种方式
 * （1）basePackages方式，扫描包及自包
 * 支持扫描多个包 @ComponentScan(basePackages = {"com.test.annotation", "com.test.bean"})
 * （2）basePackageClasses方式，扫描类所在包及子包
 * 持扫描多个包 @ComponentScan(basePackageClasses = {Student.class, Person.class})
 */
@Configuration
@ComponentScan("com.test.scan")
public class ComponentScanConfig {
}
