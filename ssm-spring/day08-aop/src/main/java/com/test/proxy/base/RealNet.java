package com.test.proxy.base;

/**
 * 真实类
 */
public class RealNet implements Net {
    public void browse() {
        System.out.println("使用浏览器上网");
    }
}
