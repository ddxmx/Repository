package com.test.day04.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component作用等同于<bean></bean>标签，用于注册bean,id默认为类名称首字母小写 和@Component注解功能类似的注解还有
 * @Controller Controller层的Component
 * @Service Service层的Component
 * @Repository Dao层的Component
 * <p>
 * 生成的bean id为类名称首字母小写
 */
@Component
//@Component("per") 为bean手动设置id
public class Person {
    @Value("张三")
    private String name;

    @Value("20")
    private int age;

    //方式一：通过属性注入
    //@Autowired
    private Dog dog;

    public Person() {
    }

    //方式二：通过构造器注入(如何让spring实例化对象时使用该构造器？)
    public Person(@Value("李四") String name, @Value("22") int age, @Autowired Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
    }

    //方式三：使用set方法注入
    @Autowired
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    /**
     * @Autowired使用在普通方法上
     */
    @Autowired
    public void test(){
        System.out.println("Person类中使用@Autowaired注解会在注入时调用一次该方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }
}
