package com.test.annotation;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Emp {
    private String name;
    private Dept dept;
}
