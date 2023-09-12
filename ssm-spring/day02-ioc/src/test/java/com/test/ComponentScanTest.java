package com.test;

import com.test.context.Person;
import com.test.scan.ComponentScanConfigClass;
import com.test.scan.ComponentScanConfig;
import com.test.scan.Student;
import com.test.scan.sub.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanTest {
    /**
     * 通过xml的方式配置包扫描路径
     * 指定包及子包下的类都会被扫描，id默认为类名称首字母小写
     */
    @Test
    public void xmlTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-componentScan.xml");

        getBeanTest(context);
    }

    /**
     * 使用注解方式，不依赖xml文件，所有的配置都使用注解
     * 通过basePackages设置包扫描路径
     */
    @Test
    public void annotationConfigNameTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        getBeanTest(context);
    }

    /**
     * 使用注解方式，不依赖xml文件，所有的配置都使用注解
     * 通过basePackageClasses设置包扫描路径
     */
    @Test
    public void annotationConfigClassTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfigClass.class);

        getBeanTest(context);
    }

    private void getBeanTest(ApplicationContext context) {
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
