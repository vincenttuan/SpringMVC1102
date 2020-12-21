package com.lab.jpa.validation;

import com.lab.jpa.entities.Department;
import com.lab.jpa.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmpValidation implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Employee.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee emp = (Employee)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "emp.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary.money", "salary.money.empty");
        if(emp.getSalary().getMoney() != null && emp.getSalary().getMoney() < 40000) {
            errors.rejectValue("salary.money", "salary.money.notenough");
        }
        
    }
    
}
