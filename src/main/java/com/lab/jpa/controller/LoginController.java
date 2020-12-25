package com.lab.jpa.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @PostMapping("/check")
    @ResponseBody
    public String check(HttpServletRequest req) {
        String id_token = req.getParameter("id_token");
        return "id_token: " + id_token;
    }
    
}
