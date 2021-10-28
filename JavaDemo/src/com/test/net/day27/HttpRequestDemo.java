package com.test.net.day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 发送Http亲贵
 */
public class HttpRequestDemo {
    public static void main(String[] args) throws IOException {
        String requestURL = "https://v0.yiketianqi.com/api?version=v61&appid=&appsecret=";
        URL url = new URL(requestURL);
        //打开连接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置本次请求的方式，默认是GET方式，参数要求都是大写字母
        conn.setRequestMethod("GET");
        //是否打开输入流 ， 此方法默认为true
        conn.setDoInput(true);
        //是否打开输出流， 此方法默认为false，post请求参数要放在http正文内，因此需要设为true
        conn.setDoOutput(true);
        //设置连接超时时间和读取超时时间
        conn.setConnectTimeout(30000);
        conn.setReadTimeout(30000);
        //post请求不能使用缓存
        conn.setUseCaches(false);

        //设置请求头参数
        //setRequestProperty会覆盖已经存在的key的所有values
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //addRequestProperty则是在原来key的基础上继续添加其他value
        conn.addRequestProperty("Content-Type", "application/json");

        //连接
        conn.connect();

        //获取响应头
        Map<String, List<String>> fields = conn.getHeaderFields();
        for (String key : fields.keySet()) {
            System.out.println(key + "--->" + fields.get(key));
        }

        //获取状态码
        System.out.println(conn.getResponseCode());

        //获取状态码描述
        System.out.println(conn.getResponseMessage());

        //获取响应体
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuffer responseBody = new StringBuffer();
        char[] buf = new char[1024];
        int len = 0;
        while ((len = bufferedReader.read(buf)) != -1) {
            responseBody.append(new String(buf, 0, len));
        }
        System.out.println("Response Body:" + responseBody.toString());

        conn.disconnect();
    }
}
