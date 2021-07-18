package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo2")
public class RestfulController {
    /**
     * 通过@PathVariable可以将 URL中占位符参数绑定到控制器处理方法的入参中
     * URL中的{xxx}占位符可以通过@PathVariable(“xxx“)绑定到操作方法的入参中。
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/test/{info}/{id}")
    public String doTest(@PathVariable String info, @PathVariable Integer id, HttpServletRequest request) {
        request.setAttribute("url", "/test/" + info + "/" + id);
        request.setAttribute("msg", "@PathVariable");
        return "hello";
    }
}
