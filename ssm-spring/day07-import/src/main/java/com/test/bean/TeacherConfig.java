package com.test.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:spring/applicationContext-teacher.xml")
public class TeacherConfig {
}
