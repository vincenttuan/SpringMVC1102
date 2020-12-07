package com.spring.mvc.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;

@Controller
public class Hello {
    
    public String time() {
        return new Date().toString();
    }
    
}
