package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lotto")
public class Lotto {
    
    @RequestMapping("/get")
    public String get() {
        
    }
}
