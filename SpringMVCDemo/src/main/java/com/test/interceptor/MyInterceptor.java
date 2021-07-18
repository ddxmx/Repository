package com.test.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器是SpringMVC框架自己的，只有使用了SpringMVC框架的工程才能使用
 * 拦截器只会拦截访问的Controller方法， 如果访问的是jsp/html/css/image/js是不会进行拦截的
 */
public class MyInterceptor implements HandlerInterceptor {
    //在请求处理的方法之前执行
    //如果返回true执行下一个拦截器
    //如果返回false就不执行下一个拦截器
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("------------处理前------------");
        return true;
    }

    //在请求处理方法执行之后执行
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView
                                   modelAndView) throws Exception {
        System.out.println("------------处理后------------");
    }

    //在dispatcherServlet处理后执行,做清理工作 .
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("------------清理------------");
    }
}
