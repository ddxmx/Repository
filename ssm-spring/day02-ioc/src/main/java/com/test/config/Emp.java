package com.test.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Emp {
    private String name;
    private Dept dept;
}
