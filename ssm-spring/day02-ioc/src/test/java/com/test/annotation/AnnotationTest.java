package com.test.annotation;

import com.test.annotation.sub.Teacher;
import com.test.bean.Person;
import com.test.config.BasePackageClassesConfig;
import com.test.config.BasePackagesConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    /**
     * 通过xml的方式配置包扫描路径
     */
    @Test
    public void componentScanTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-componentScan.xml");

        // component-scan指定包下的类
        Student student = context.getBean("student", Student.class);
        System.out.println(student);

        // component-scan指定包下的子包中的类
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);

        // 不在component-scan指定的包中，无法被扫描到
        Person person = context.getBean("person", Person.class);
        System.out.println(person); // NoSuchBeanDefinitionException: No bean named 'person' available
    }

    /**
     * 使用注解方式，不依赖xml文件，所有的配置都使用注解
     * 通过basePackages设置包扫描路径
     */
    @Test
    public void annotationBackPackageTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BasePackagesConfig.class);
        // component-scan指定包下的类
        Student student = context.getBean("student", Student.class);
        System.out.println(student);

        // component-scan指定包下的子包中的类
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);

        // 不在component-scan指定的包中，无法被扫描到
        Person person = context.getBean("person", Person.class);
        System.out.println(person); // NoSuchBeanDefinitionException: No bean named 'person' available
    }

    /**
     * 使用注解方式，不依赖xml文件，所有的配置都使用注解
     * 通过basePackageClasses设置包扫描路径
     */
    @Test
    public void annotationBackPackageClassTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BasePackageClassesConfig.class);
        // component-scan指定包下的类
        Student student = context.getBean("student", Student.class);
        System.out.println(student);

        // component-scan指定包下的子包中的类
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);

        // 不在component-scan指定的包中，无法被扫描到
        Person person = context.getBean("person", Person.class);
        System.out.println(person); // NoSuchBeanDefinitionException: No bean named 'person' available
    }
}
