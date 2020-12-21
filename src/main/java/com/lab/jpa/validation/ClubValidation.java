package com.lab.jpa.validation;

import com.lab.jpa.entities.Club;
import com.lab.jpa.entities.Department;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ClubValidation implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Club.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Club club = (Club)o;
        if(club.getName() == null || club.getName().trim().length() == 0) {
            errors.reject("club.name", "社團名稱不可空白");
        }
    }
    
}
