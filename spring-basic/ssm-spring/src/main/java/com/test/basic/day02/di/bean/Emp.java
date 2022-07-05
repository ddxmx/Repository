package com.test.basic.day02.di.bean;

public class Emp {
    private String name;
    private Dept dept;

    public Emp() {
    }

    public Emp(String name, Dept dept) {
        this.name = name;
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Emp=[name=" + name + ",Dept=[location=" + dept.getLocation() + "]]";
    }
}
