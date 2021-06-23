package com.test.ioc;

public class Hello {
    private String name;

    public Hello() {
        System.out.println("Hello类实例化...");
    }

    public Hello(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Hello，" + name);
    }
}
