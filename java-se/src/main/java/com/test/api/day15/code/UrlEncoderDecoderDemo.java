package com.test.api.day15.code;

import java.net.MalformedURLException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Url编码和解码
 */
public class UrlEncoderDecoderDemo {
    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
        String urlStr = "http://127.0.0.1:8080/test/submit?name=zhangsan&age=20";
        URL url = new URL(urlStr);
        System.out.println("请求协议：" + url.getProtocol()); // 请求协议：http

        System.out.println("请求地址：" + url.getHost()); // 请求地址：127.0.0.1

        System.out.println("请求地址：" + url.getPort()); // 请求地址：8080

        String path = url.getPath();
        System.out.println("请求路径：" + path); // 请求路径：/test/submit

        String query = url.getQuery();
        System.out.println("请求参数：" + query); // 请求参数：name=zhangsan&age=20

        // 待编码解码的url
        String rawPath = null == query ? path : path + "?" + query;

        // url编码
        // public static String encode(String s, String enc) throws UnsupportedEncodingException
        String encodeStr = URLEncoder.encode(rawPath, StandardCharsets.UTF_8.toString());
        System.out.println(encodeStr); // %2Ftest%2Fsubmit%3Fname%3Dzhangsan%26age%3D20

        // url解码
        // public static String decode(String s, String enc) throws UnsupportedEncodingException
        String decodeStr = URLDecoder.decode(encodeStr, StandardCharsets.UTF_8.toString());
        System.out.println(decodeStr); // /test/submit?name=zhangsan&age=20
    }
}
