package com.test.controller;

import com.test.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo3")
@ResponseBody
public class ParamController {
    /**
     * 逐个接收请求中的参数
     * 请求中参数名和方法中参数名必须一致
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/doEachParam", produces = {"text/plain;charset=utf-8"})
    public String paramDo(String name, Integer age) {
        String msg = "name = " + name + ",age = " + age;
        //通过post请求提交的数据，请求体里面的中文会有乱码问题，需要在CharacterEncodingFilter中统一配置
        System.out.println(msg);
        return msg;
    }

    /**
     * 请求体中的参数和方法参数不一致
     *
     * @param userName
     * @param userAge
     * @return
     */
    @PostMapping(value = "/doIgnoreParam", produces = {"text/plain;charset=utf-8"})
    /*
        语法：@RequestParam(value=”参数名”,required=”true/false”,defaultValue=””)
        value：参数名
        required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。
        defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值
        以下表示请求参数中（url或body表单）name参数必须存在，age参数可以不存在
     */
    //参数不要使用基本数据类型，当参数名不匹配赋值失败时，基本数据类型无法赋值为null，将导致异常
    public String doIgnoreParam(@RequestParam("name") String userName, @RequestParam(value = "age", required = false) Integer userAge) {
        String msg = "userName = " + userName + ",userAge = " + userAge;
        System.out.println(msg);
        return msg;
    }

    /**
     * 前端传递的参数会使用接收对象的属性设置值
     * 属性名称不一致时属性值为null
     */
    @PostMapping(value = "/doObjectParam",produces = {"text/plain;charset=utf-8"})
    //User对象的创建由框架自己完成
    public String paramObjectDo(User user) {
        System.out.println(user);
        return user.toString();
    }
}
