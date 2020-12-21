package com.lab.jpa.validation;

import com.lab.jpa.entities.Department;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class DeptValidation implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Department.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Department dept = (Department)o;
        if(dept.getName() == null || dept.getName().trim().length() == 0) {
            errors.reject("dept.name", "部門名稱不可空白");
        }
    }
    
}
