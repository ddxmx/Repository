package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 如果运行代码没有进入Controller，检查下project structure中Artifacts中发布的项目下，WEB-INF下是否有lib目录
 */
@Controller
@RequestMapping("/demo1")
public class RequestController {

    /**
     * @return
     * @RequestMapping可以用在类或方法上 实际访问地址 项目名/demo1/test.do
     */
    @RequestMapping("/test.do")
    public ModelAndView doLogin() {
        //用于将数据带到视图层
        ModelAndView mv = new ModelAndView();

        //添加数据
        mv.addObject("url", "/test.do");
        mv.addObject("msg", "hello");

        //添加视图
        //视图解析器不配置前后缀时，需要写上完整路径
        //mv.setViewName("/WEB-INF/jsp/hello.jsp");

        //视图解析器配置前后缀时，只需要写逻辑名称
        mv.setViewName("hello");
        return mv;
    }


    /**
     * 只能通过post方式访问
     * 如果直接通过浏览器访问（使用GET方式），则会出现405 方法不允许错误
     * 没有指定method则任何类型都支持
     *
     * @return
     */
    @RequestMapping(value = "/post.do", method = RequestMethod.POST)
    public ModelAndView doPost() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", "/post.do");
        mv.addObject("msg", RequestMethod.POST.toString());
        mv.setViewName("hello");
        return mv;
    }


    /**
     * 使用@PostMapping注解表明只支持post请求映射
     *
     * @return
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     * @PostMapping 是一个组合注解
     * 它所扮演的是 @RequestMapping(method =RequestMethod.POST) 的一个快捷方式。
     */
    @PostMapping("/postMapping.do")
    public ModelAndView doPostMapping() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", "/postMapping.do");
        mv.addObject("msg", RequestMethod.POST.toString());
        mv.setViewName("hello");
        return mv;
    }

    /**
     * 通过ModelMap将数据传递到前端
     *
     * @param map
     * @return
     */
    @GetMapping("/modelMap.do")
    public String doModelMap(ModelMap map) {
        map.put("url", "/modelMap.do");
        map.put("msg", "doModelMap");
        return "hello";
    }

    /**
     * 通过Model将数据传递到前端
     *
     * @return
     */
    @GetMapping("/model.do")
    public String doModelMap(Model model) {
        model.addAttribute("url", "/model.do");
        model.addAttribute("msg", "doModel");
        return "hello";
    }
}
