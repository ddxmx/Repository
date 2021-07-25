package com.test.controller;

import com.test.bean.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo4")
public class ResultController {

    @GetMapping("/doJsonResult")
    @ResponseBody
    public User doJsonResult() {
        User user = new User("jerry", 12);
        return user;
    }

    @GetMapping("/doStatusResult")
    public ResponseEntity doStatusResult() {
        User user = new User("张三", 20);
        return new ResponseEntity(user, HttpStatus.UNAUTHORIZED);
    }
}
