package com.test.net.day19;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL操作类
 */
public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com/more/");
            // 协议
            System.out.println(url.getProtocol()); // https
            // 主机名
            System.out.println(url.getHost()); // www.baidu.com
            // 端口，没有设置时返回-1
            System.out.println(url.getPort()); // -1
            // 路径
            System.out.println(url.getPath()); // /more/
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
