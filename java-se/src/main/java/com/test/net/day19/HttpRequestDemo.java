package com.test.net.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * 发送Http亲贵
 */
public class HttpRequestDemo {
    public static void main(String[] args) throws IOException {
        String requestURL = "https://v0.yiketianqi.com/api?version=v61&appid=&appsecret=";
        URL url = new URL(requestURL);
        // 打开连接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置本次请求的方式，默认是GET方式，参数要求都是大写字母
        conn.setRequestMethod("GET");
        // 是否打开输入流 ， 此方法默认为true
        conn.setDoInput(true);
        // 是否打开输出流， 此方法默认为false，post请求参数要放在http正文内，因此需要设为true
        conn.setDoOutput(true);
        // 设置连接超时时间和读取超时时间
        conn.setConnectTimeout(30000);
        conn.setReadTimeout(30000);
        // post请求不能使用缓存
        conn.setUseCaches(false);

        // 设置请求头参数
        // setRequestProperty会覆盖已经存在的key的所有values
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        // addRequestProperty则是在原来key的基础上继续添加其他value
        conn.addRequestProperty("Content-Type", "application/json");

        // 连接
        conn.connect();

        // 获取响应头
        Map<String, List<String>> fields = conn.getHeaderFields();
        for (String key : fields.keySet()) {
            System.out.println(key + "--->" + fields.get(key));
        }

        // 获取状态码
        System.out.println(conn.getResponseCode());

        // 获取状态码描述
        System.out.println(conn.getResponseMessage());

        // 获取响应体
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),
                StandardCharsets.UTF_8.toString()));
        StringBuffer sb = new StringBuffer();
        char[] buf = new char[1024];
        int len = 0;
        while ((len = bufferedReader.read(buf)) != -1) {
            sb.append(new String(buf, 0, len));
        }
        System.out.println("Response Body:" + sb.toString());
        System.out.println(unicodeDecode(sb.toString()));

        conn.disconnect();
    }

    /**
     * unicode解码（unicode编码转中文）
     */
    public static String unicodeDecode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);

                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

}
