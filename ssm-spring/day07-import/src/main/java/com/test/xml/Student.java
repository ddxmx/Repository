package com.test.xml;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private String name;
    private Teacher teacher;
}
