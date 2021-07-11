package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/restful")
public class RestfulController {

    /**
     * 通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中
     * URL 中的 {xxx} 占位符可以通过@PathVariable(“xxx“) 绑定到操作方法的入参中。
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/test/{id}.do")
    public String test(@PathVariable String id, HttpServletRequest request) {
        request.setAttribute("url", "/test/" + id + ".do");
        request.setAttribute("msg", id);
        return "hello";
    }
}
