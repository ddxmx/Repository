package com.test.controller;

import com.test.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/demo4")
public class ResultController {

    @GetMapping("/doJsonResult")
    public User doJsonResult() {
        User user = new User("jerry", 12);
        return user;
    }
}
