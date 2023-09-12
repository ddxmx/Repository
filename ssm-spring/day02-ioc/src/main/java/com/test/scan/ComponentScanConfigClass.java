package com.test.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 不使用xml方式配置包扫描路径，直接使用注解方式
 * basePackageClasses方式，扫描类所在包及子包
 * 持扫描多个包 @ComponentScan(basePackageClasses = {Student.class, Person.class})
 */
@Configuration
@ComponentScan(basePackageClasses = Student.class)
public class ComponentScanConfigClass {
}
