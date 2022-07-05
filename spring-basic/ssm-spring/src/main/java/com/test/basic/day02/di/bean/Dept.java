package com.test.basic.day02.di.bean;

public class Dept {
    private String location;
    private Emp emp;

    public Dept() {
    }

    public Dept(String location, Emp emp) {
        this.location = location;
        this.emp = emp;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }


    public String getLocation() {
        return location;
    }

    public Emp getEmp() {
        return emp;
    }

    @Override
    public String toString() {
        return "Dept=[location=" + location + ",Emp=[name=" + emp.getName() + "]]";
    }
}
