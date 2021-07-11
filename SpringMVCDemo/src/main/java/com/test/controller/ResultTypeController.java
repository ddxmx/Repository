package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/demo2")
public class ResultTypeController {

    /**
     * SpringMVC的@ResponseBody注解可以将请求方法返回的对象直接转换成JSON对象，但是当返回值是String的时候，中文会乱码，
     * 原因是因为其中字符串转换和对象转换用的是两个转换器，而String的转换器中固定了转换编码为"ISO-8859-1"；
     * <p>
     * 需要使用produces指定编码格式，实际上设置的Content-Type属性
     * 也可以在pringmvc.xml中统一配置处理
     *
     * @return
     */
    @GetMapping(value = "/string.do", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String doString() {
        User user = new User("张三", 20);
        String jsonString = JSON.toJSONString(user);
        return jsonString;
    }

    /**
     * 不手动配置，使用统一配置
     *
     * @return
     */
    @GetMapping("/string2.do")
    @ResponseBody
    public String doString2() {
        User user = new User("李四", 22);
        String jsonString = JSON.toJSONString(user);
        return jsonString;
    }

    /**
     * 直接返回对象
     *
     * @return
     */
    @GetMapping("/object.do")
    @ResponseBody
    public User doObject() {
        User user = new User("jsonObject", 19);
        return user;
    }

}
