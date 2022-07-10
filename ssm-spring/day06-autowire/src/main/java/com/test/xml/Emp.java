package com.test.xml;

import lombok.Data;

@Data
public class Emp {
    private String ename;
    private Dept dept;

    @Override
    public String toString() {
        return "com.test.xml.Emp{" +
                "ename='" + ename + '\'' +
                ", dept=" + dept +
                '}';
    }
}
