package com.lab.jpa.controller;

import com.lab.jpa.entities.Department;
import com.lab.jpa.repository.CompanyDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dept")
public class DeptController {
    
    @Autowired
    private CompanyDao dao;
    
    @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
    public String read(Model model) {
        List dept_list = dao.queryAllDepts();
        Department dept = new Department();
        model.addAttribute("dept_list", dept_list);
        model.addAttribute("dept", dept);
        return "dept_page";
    }
    
    @RequestMapping(value = {"/"}, method = {RequestMethod.POST})
    public String create(@ModelAttribute("dept") Department dept) {
        dao.saveDept(dept);
        return "redirect: ./";
    }
    
}
