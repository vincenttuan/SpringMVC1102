package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/club")
public class ClubController {
    
    @RequestMapping(value = {"/"})
    public String read() {
        return "club_page";
    }
    
}
