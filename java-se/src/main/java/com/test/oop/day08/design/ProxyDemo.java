package com.test.oop.day08.design;

interface Net {
    public void browse();
}

/**
 * 真实类
 */
class RealNet implements Net {
    @Override
    public void browse() {
        System.out.println("使用浏览器上网");
    }
}

/**
 * 静态代理类
 */
class ProxyNet implements Net {
    private Net net;

    // 构造方法接收真实类对象
    public ProxyNet(Net net) {
        this.net = net;
    }

    @Override
    public void browse() {
        System.out.println("初始化代理");
        // 调用真实类的操作
        this.net.browse();
        System.out.println("停止代理");
    }
}

/**
 * 接口设计：静态代理设计模式
 */
public class ProxyDemo {
    public static void main(String[] args) {
        /*
            初始化代理
            使用浏览器上网
            停止代理
         */
        Net realNet = new RealNet();
        Net proxyNet = new ProxyNet(realNet);
        proxyNet.browse();
    }
}
