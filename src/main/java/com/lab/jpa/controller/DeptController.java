package com.lab.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept")
public class DeptController {
    
    @RequestMapping(value = {"/"})
    public String read() {
        return "dept_page";
    }
    
}
