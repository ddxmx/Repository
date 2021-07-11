package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
 * 1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 例如：本来应该到success.jsp页面的，则其显示success.
 * 2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 */
@RestController
@RequestMapping("/demo3")
public class ResultTypeRestController {

    @GetMapping("/test.do")
    public String test() {
        User user = new User("王五", 18);
        String jsonString = JSON.toJSONString(user);
        return jsonString;
    }

}
