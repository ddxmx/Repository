package com.test.net.day19;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址和域名操作类
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            // 获取本机IP地址
            String hostAddress = localHost.getHostAddress();
            System.out.println(hostAddress);

            // 获取本机主机名
            String hostName = localHost.getHostName();
            System.out.println(hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String hostname = "www.baidu.com";
        try {
            // 获取域名的IP地址
            InetAddress address = InetAddress.getByName(hostname);
            String hostAddress = address.getHostAddress();
            System.out.println(hostAddress);

            // 获取域名的所有IP地址
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            for (InetAddress addr : addresses) {
                System.out.println(addr.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
