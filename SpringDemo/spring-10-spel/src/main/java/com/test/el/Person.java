package com.test.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Value("#{'tom'}")
    private String name;

    @Value("#{20}")
    private int age;

    /**
     * 不使用@Autowired，使用spel表达式注入
     */
    @Value("#{car}")
    private Car car;

    @Value("#{car.getRandomValue()}")
    private double value;

    @Value("#{car.getUpperCase('Hello')}")
    private String value2;

    /**
     * 使用?.符号代表若然左边的值为null,将不执行右边方法,
     * 可以灵活运用在其他场景,只要左边可能返回null,
     */
    @Value("#{car.getUpperCase('null')?.length()}")
    private String value3;

    /**
     * SpringEL调用静态类或常量
     * 注入JDK中的工具类常量或调用工具类的方法，包.类名称
     */
    @Value("#{T(System).currentTimeMillis()}")
    private long time;

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

    public Car getCar() {
        return car;
    }

    //@Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ",value =" + value +
                ",value2 =" + value2 +
                ",value3 =" + value3 +
                ",time =" + time +
                '}';
    }
}
