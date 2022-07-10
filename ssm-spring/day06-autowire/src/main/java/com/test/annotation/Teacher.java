package com.test.annotation;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class Teacher {
    @Value("Helen")
    private String name;
}
