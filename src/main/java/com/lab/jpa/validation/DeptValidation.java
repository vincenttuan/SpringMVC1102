package com.lab.jpa.validation;

import com.lab.jpa.entities.Department;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DeptValidation implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Department.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Department dept = (Department)o;
        ValidationUtils.rejectIfEmpty(errors, "name", "dept.name.empty");
//        if(dept.getName() == null || dept.getName().trim().length() == 0) {
//            errors.reject("name", "部門名稱不可空白");
//        }
    }
    
}
