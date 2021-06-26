package com.test.ioc;

public class Hello {
    private String info;

    public Hello() {
        System.out.println("Hello类实例化...");
    }

    public Hello(String info) {
        this();
        this.info = info;
    }

    public void initAction(){
        System.out.println("初始化操作...");
    }

    public void destoryAction(){
        System.out.println("销毁操作...");
    }

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
