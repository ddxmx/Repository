package com.test.annotation;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component作用等同于<bean></bean>标签，用于注册bean，id默认为类名称首字母小写
 */
@Component
@Data
@ToString
public class Student {
    @Value("Tom")
    private String name;
}
