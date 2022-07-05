package com.test;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Dept {
    private String dname;
    private List<String> location;
    private Emp[] emps;
}
