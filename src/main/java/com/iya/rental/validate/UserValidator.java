package com.iya.rental.validate;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iya.rental.domain.repository.UserRepository;
import com.iya.rental.dto.request.UserRequest;
import com.iya.rental.util.ValidationUtil;

@Component
public class UserValidator{

    @Autowired
    UserRepository userRepository;

    public String validateUser(UserRequest vo){
        
        if (ValidationUtil.isEmptyOrNull((vo.getName()))) {
            return "Name can't be empty";
        }

        if (ValidationUtil.isEmptyOrNull((vo.getEmail()))) {
            return "Email can't be empty";
        }
        
        if (ValidationUtil.isEmptyOrNull((vo.getPhone()))) {
            return "Phone can't be empty";
        }
        User email = (User) userRepository.findByEmail(vo.getEmail());
        if (email != null){
            return "email all ready exist";
        }
            
        return null;
    }
}
