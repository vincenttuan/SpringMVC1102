package com.lab.jpa.controller;

import com.lab.jpa.entities.Club;
import com.lab.jpa.entities.Employee;
import com.lab.jpa.repository.CompanyDao;
import com.lab.jpa.validation.EmpValidation;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private CompanyDao dao;

    @Autowired
    private EmpValidation validation;

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
    public String read(Model model) {
        List emp_list = dao.queryAllEmps();
        List dept_list = dao.queryAllDepts();
        List club_list = dao.queryAllClubs();
        Employee emp = new Employee();

        model.addAttribute("emp_list", emp_list);
        model.addAttribute("dept_list", dept_list);
        model.addAttribute("club_list", club_list);
        model.addAttribute("emp", emp);

        return "emp_page";
    }

    @RequestMapping(value = {"/"}, method = {RequestMethod.POST})
    //@ResponseBody
    public String create(@ModelAttribute("emp") Employee emp,
            BindingResult result, Model model,
            @RequestParam Optional<int[]> clubIds) {
        // 數據驗證 
        validation.validate(emp, result);
        if (result.hasErrors()) {
            model.addAttribute("emp_list", dao.queryAllEmps());
            model.addAttribute("dept_list", dao.queryAllDepts());
            model.addAttribute("club_list", dao.queryAllClubs());
            model.addAttribute("emp", emp);
            return "emp_page";
        }

        if (clubIds.isPresent()) {
            for (Integer id : clubIds.get()) {
                Club club = dao.getClub(id);
                emp.getClubs().add(club);
            }
        }
        dao.saveEmp(emp);
        return "redirect: ./";
        //return emp.toString();
    }

}
