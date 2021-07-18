package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @RequestMapping可以用在类或方法上 实际访问地址：项目名/demo1/test.do
     */
    @RequestMapping("/doTest")
    public ModelAndView doTest() {
        //用于将数据带到视图层
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("url", "/doTest");
        mv.addObject("msg", "hello");
        //添加视图
        //视图解析器不配置前后缀时，需要写上完整路径
        //mv.setViewName("/WEB-INF/jsp/hello.jsp");
        //视图解析器配置前后缀时，只需要写逻辑名称
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "/doGet",method = RequestMethod.GET)
    public ModelAndView doGet() {
        //用于将数据带到视图层
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("url", "/doGet");
        mv.addObject("msg", "hello");
        //添加视图
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "/doPost",method = RequestMethod.POST)
    public ModelAndView doPost() {
        //用于将数据带到视图层
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("url", "/doPost");
        mv.addObject("msg", "hello");
        //添加视图
        mv.setViewName("hello");
        return mv;
    }

    /**
     * 通过ModelMap将数据传递到前端
     *
     * @param map
     * @return
     */
    @GetMapping("/doModelMap")
    public String doModelMap(ModelMap map) {
        map.put("url", "/doModelMap");
        map.put("msg", "ModelMap");
        return "hello";
    }

    /**
     * 通过Model将数据传递到前端
     *
     * @return
     */
    @GetMapping("/doModel")
    public String doModel(Model model) {
        model.addAttribute("url", "/doModel");
        model.addAttribute("msg", "Model");
        return "hello";
    }
}
