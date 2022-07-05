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
        String rawUrl = "http://127.0.0.1:8080/test/submit?name=zhangsan&age=20";
        URL url = new URL(rawUrl);
        // 获取url中路径
        String path = url.getPath();
        System.out.println("请求路径：" + path);
        // 获取请求参数
        String query = url.getQuery();
        System.out.println("请求参数：" + query);

        // 待编码解码的url
        String rawPath = null == query ? path : path + "?" + query;

        // url编码
        // public static String encode(String s, String enc) throws UnsupportedEncodingException
        String encodeStr = URLEncoder.encode(rawPath, StandardCharsets.UTF_8.toString());
        System.out.println(encodeStr);

        // url解码
        // public static String decode(String s, String enc) throws UnsupportedEncodingException
        String decodeStr = URLDecoder.decode(encodeStr, StandardCharsets.UTF_8.toString());
        System.out.println(decodeStr);
    }
}
