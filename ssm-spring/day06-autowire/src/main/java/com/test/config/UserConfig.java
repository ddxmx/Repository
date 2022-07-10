package com.test.config;

import com.test.dao.UserDao;
import com.test.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {UserDao.class, UserService.class})
public class UserConfig {
}
