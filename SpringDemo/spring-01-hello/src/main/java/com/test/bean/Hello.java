package com.test.bean;

public class Hello {
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void show() {
        System.out.println("Hello，" + info);
    }
}
