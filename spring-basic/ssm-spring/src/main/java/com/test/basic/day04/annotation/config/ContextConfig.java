package com.test.basic.day04.annotation.config;

import com.test.basic.day04.annotation.bean.Person;
import com.test.basic.day04.annotation.bean.Student;
import com.test.basic.day04.annotation.bean.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Import("XXX.class")  导入其他配置类，类似于xml中的<import></import>标签
 * @ImportResource("classpath:day01-ioc.xml")  导入xml信息导入到配置类中
 */
@Configuration
@ComponentScan(basePackageClasses = Person.class)
public class ContextConfig {
    //默认名称为方法名称
    //@Bean

    //可以手工指定bean id
    @Bean("stu")
    public Student getStudent() {
        /*
            Student Bean对象的创建依赖Teacher对象，直接调用Teacher Bean对象生成的方法
            getTeacher方法上添加了@Bean注解， Spring将会拦截所有对它的调用，
            并确保直接返回该方法所创建的bean， 而不是每次都对其进行实际的调用。
         */
        return new Student(getTeacher());
    }

    /**
     * 假如Teacher已经在其他地方注册
     * 如何在创建Student对象的时候自动装配
     * 在方法参数上传入Teacher对象即可
     *
     * @return
     */
    @Bean("student")
    public Student getStudent2(Teacher teacher) {
        return new Student(teacher);
    }

    @Bean
    public Teacher getTeacher() {
        return new Teacher(1001);
    }
}
