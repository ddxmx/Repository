package com.test.basic.day01.hello.config;

import com.test.basic.day01.hello.dao.UserMysqlDaoImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * java配置类，@Configuration等同于xml中的<beans></beans>标签
 * bean配置的推荐顺序：bean注解自动发现 > java配置注册bean > xml配置
 *
 * @ComponentScan 使注解 @Component、@Controller、@Service、@Repository生效
 * 默认扫描@Configuration标记的类所在包及子包
 * 有两种使用方式：
 * 1、使用basePackages属性，传入包的全限定名，可以传入多个
 * 2、使用basePackageClasses属性，传入xxx.class，表示扫描类所在包
 */
//
@Configuration
//@ComponentScan("com.test.basic.day01.ioc.dao")
//使用字符串方式在方法重构时是不安全的，类所在包或包的名字可能发生改变，可以使用class的方式
@ComponentScan(basePackageClasses = {UserMysqlDaoImpl.class})
public class UserConfig {
}
