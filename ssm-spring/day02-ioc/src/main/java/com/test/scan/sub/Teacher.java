package com.test.scan.sub;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Teacher {
    @Value("Jerry")
    private String name;
}
