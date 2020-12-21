package com.lab.jpa.controller;

import com.lab.jpa.entities.Department;
import com.lab.jpa.repository.CompanyDao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dept")
public class DeptController {
    
    @Autowired
    private CompanyDao dao;
    
    @GetMapping(value = {"/", // 查詢全部資料用
                         "/{id}", // 根據 id 查詢單筆使用 (給修改連結用)
                         "/{delete}/{id}"}) // 根據 id 查詢單筆使用 (給刪除連結用)
    public String read(Model model, 
            @PathVariable Optional<Integer> id,
            @PathVariable Optional<String> delete) {
        String _method = "POST";
        List dept_list = dao.queryAllDepts();
        Department dept = new Department();
        if(id.isPresent()) {
            _method = "PUT";
            dept = dao.getDept(id.get());
            // 根據路徑參數是否有 delete 字樣
            if(delete.isPresent() && delete.get().equalsIgnoreCase("delete")) {
                _method = "DELETE";
            }
        }
        model.addAttribute("_method", _method);
        model.addAttribute("dept_list", dept_list);
        model.addAttribute("dept", dept);
        return "dept_page";
    }
    
    @PostMapping(value = {"/"})
    public String create(@ModelAttribute("dept") Department dept) {
        dao.saveDept(dept);
        return "redirect: ./";
    }
    
    @PutMapping(value = {"/"})
    public String update(@ModelAttribute("dept") Department dept) {
        //dao.updateDept(dept);
        return "redirect: ./";
    }
    
    @DeleteMapping(value = {"/"})
    public String delete(@ModelAttribute("dept") Department dept) {
        //dao.deleteDept(dept.getId());
        return "redirect: ./";
    }
    
}
