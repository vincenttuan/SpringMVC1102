package com.lab.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpController {
    
    @RequestMapping(value = {"/"})
    public String read() {
        return "emp_page";
    }
    
}
