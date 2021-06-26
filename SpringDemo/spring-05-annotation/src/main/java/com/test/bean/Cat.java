package com.test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 把对象添加到容器中,首字母会小写
 */
@Component
public class Cat {
    @Value("花花")
    private String name;

    public String getName() {
        return name;
    }
}
