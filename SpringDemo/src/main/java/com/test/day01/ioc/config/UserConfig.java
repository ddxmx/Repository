package com.test.day01.ioc.config;

import com.test.day01.ioc.dao.UserMysqlDaoImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 通过java类的方式注册bean
 * 使用推荐顺序：bean自动发现、java配置、xml配置
 *
 * @ComponentScan默认扫描当前类所在包及子包
 */
@Configuration
//@ComponentScan("com.test.day01.ioc.dao")
//使用字符串方式在方法重构时时不安全的，可以使用class的方式
@ComponentScan(basePackageClasses = {UserMysqlDaoImpl.class})
public class UserConfig {
}
