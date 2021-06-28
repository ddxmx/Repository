package com.test.day03.autowire.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 使用@Autowired注解，可以使用在属性、构造方法、set方法上
 * 在属性上使用@Autowired注解，可以不用写set方法，原因是spring会将属性权限设置可见后修改属性值
 * Autowired不支持设置名称，先根据type，再根据name
 * Resource可以指定名称，先根据name，再根据type
 * Qualifier可以指定名称，想按名称装配，除了使用@Resource外，可以联合使用@Autowired和@Qualifier
 */
public class Worker {
    private String name;
    private int age;

    //自动装配，从spring容器中寻找Car类型的bean进行
    /**
     * 先根据type，再根据name
     * xml中存在bean id：car car2 car3，则先根据类型找到3个bean，再根据名称找到car
     * 如果只存在car2 car3，则自动装配失败
     */
    //@Autowired
    //private Car car;

    //autowire要想支持按指定名称寻找bean，需要@Qualifier注解的支持
    @Qualifier("car3")
    @Autowired
    private Car car;

    /**
     * 先根据name，再根据type
     * xml中存在bean id:car car2 car3，则先根据名称查找，直接找到car
     * 如果只存在car2 car3，则存在多个满足条件的bean，导致异常
     * 以上情况可以指定要找到的bean的名称
      */
    //@Resource
    //private Car car;

    //@Resource(name="car2")
    //private Car car;

    public Worker() {
    }

    public Worker(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
