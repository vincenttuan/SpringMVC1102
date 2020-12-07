package com.spring.mvc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @ResponseBody
    public String add(@PathVariable int x, @PathVariable int y) {
        int sum = x + y;
        return sum + "";
    }
    
    /*
        Ant 語法:
        * : 任意多字
        ? : 任意一字
        ** : 任意多組資料夾
    */
    //@RequestMapping("/*/antpath")
    //@RequestMapping("/java?/antpath")
    @RequestMapping("/**/antpath")
    @ResponseBody
    public String antPath() {
        return "Ant path success !";
    }
    
    // login?username=admin&password=1234
    // check?username=admin&password=1234
    // login?username=admin
    @RequestMapping(value = {"/login", "/check"})
    @ResponseBody
    public String login(@RequestParam String username, 
                        @RequestParam(required = false) String password) {
        return username + ", " + password + ", Login OK";
    }
    
    // login2?usr=admin&pwd=1234
    @RequestMapping(value = {"/login2"})
    @ResponseBody
    public String login2(@RequestParam(name = "usr") String username, 
                         @RequestParam(name = "pwd") String password) {
        return username + ", " + password + ", Login2 OK";
    }
    
    // login3?usr=admin&pwd=1234&age=20&level=7 ...
    @RequestMapping(value = {"/login3"})
    @ResponseBody
    public String login3(@RequestParam Map<String, String> params) {
        return params + " Login3 OK";
    }
    
    // login4?id=1,5,6,8,15,20
    @RequestMapping(value = {"/login4"})
    @ResponseBody
    public String login4(@RequestParam(name = "id") List<String> ids) {
        return ids + " Login4 OK";
    }
    
}
