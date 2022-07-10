package com.test.config;

import com.test.aspect.LogAnnotationAspect;
import com.test.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {LogAnnotationAspect.class,UserService.class})
@EnableAspectJAutoProxy
public class LogConfig {
}
