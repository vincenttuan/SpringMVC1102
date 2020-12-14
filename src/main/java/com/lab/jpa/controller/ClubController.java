package com.lab.jpa.controller;

import com.lab.jpa.repository.CompanyDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/club")
public class ClubController {
    
    @Autowired
    private CompanyDao dao;
    
    @RequestMapping(value = {"/"})
    public String read(Model model) {
        List club_list = dao.queryAllClubs();
        model.addAttribute("club_list", club_list);
        return "club_page";
    }
    
}
