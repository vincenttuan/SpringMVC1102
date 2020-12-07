package com.spring.mvc.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class Hello {
    
    @RequestMapping("/time")
    @ResponseBody
    public String time() {
        return new Date().toString();
    }
    
    @RequestMapping("/add/{x}/{y}")
    public String add(@PathVariable int x, @PathVariable int y) {
        int sum = x + y;
        return sum + "";
    }
    
}
