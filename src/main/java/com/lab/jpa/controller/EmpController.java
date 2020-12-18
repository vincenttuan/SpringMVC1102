package com.lab.jpa.controller;

import com.lab.jpa.entities.Employee;
import com.lab.jpa.repository.CompanyDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpController {
    
    @Autowired
    private CompanyDao dao;
    
    @RequestMapping(value = {"/"})
    public String read(Model model) {
        List emp_list = dao.queryAllEmps();
        List dept_list = dao.queryAllDepts();
        List club_list = dao.queryAllClubs();
        Employee emp = dao.getEmp(1); //new Employee();
        
        model.addAttribute("emp_list", emp_list);
        model.addAttribute("dept_list", dept_list);
        model.addAttribute("club_list", club_list);
        model.addAttribute("emp", emp);
        
        return "emp_page";
    }
    
}
