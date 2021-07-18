package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo5")
public class ForwardRedirectController {

    /**
     * 转发方式一：
     *
     * @return
     */
    @GetMapping("/doForward")
    public String doForward(HttpServletRequest request) {
        request.setAttribute("url", "/doForward");
        request.setAttribute("msg", "转发方式一");
        return "hello";
    }

    /**
     * 转发方式二：
     *
     * @return
     */
    @GetMapping("/doAnotherForward")
    public String doAnotherForward(HttpServletRequest request) {
        request.setAttribute("url", "/doAnotherForward");
        request.setAttribute("msg", "转发方式二");
        //带了forward:后不再被视图解析器处理前后缀
        return "forward:/WEB-INF/jsp/hello.jsp";
    }

    /**
     * 重定向方式
     * 重定向方式无法访问WEB-INF下的资源
     *
     * @param request
     * @return
     */
    @GetMapping("/doRedirect")
    public String doRedirect(HttpServletRequest request) {
        //重定向方式无法获取之前request中的参数
        request.setAttribute("url", "/doRedirect");
        request.setAttribute("msg", "重定向方式");

        //redirect:后不再被视图解析器处理前后缀
        //重定向方式是返回给客户端一个新的url，让客户端重新请求，无法访问WEB-INF下的资源，转发可以访问
        //return "redirect:/WEB-INF/jsp/hello.jsp";

        return "redirect:http://www.baidu.com";
    }
}
