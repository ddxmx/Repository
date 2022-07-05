package com.test;

import lombok.Data;

@Data
public class Emp {
    private String ename;
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", dept=" + dept.getDname() +
                '}';
    }
}
