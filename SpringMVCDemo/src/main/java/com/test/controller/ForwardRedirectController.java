package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/fr")
public class ForwardRedirectController {

    /**
     * 转发方式一：
     *
     * @return
     */
    @GetMapping("/forward.do")
    public String forward(HttpServletRequest request) {
        request.setAttribute("url", "/forward.do");
        request.setAttribute("msg", "转发方式一");
        return "hello";
    }

    /**
     * 转发方式二：
     *
     * @return
     */
    @GetMapping("/forward2.do")
    public String forward2(HttpServletRequest request) {
        request.setAttribute("url", "/forward2.do");
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
    @GetMapping("/redirect.do")
    public String redirect(HttpServletRequest request) {
        //重定向方式无法获取之前request中的参数
        request.setAttribute("url", "/redirect.do");
        request.setAttribute("msg", "重定向方式");

        //redirect:后不再被视图解析器处理前后缀
        //重定向方式是返回给客户端一个新的url，让客户端重新请求，无法访问WEB-INF下的资源，转发可以访问
        //return "redirect:/WEB-INF/jsp/redirect.jsp";

        return "redirect:/redirect.jsp";
    }
}
