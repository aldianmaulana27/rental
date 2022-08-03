package com.iya.rental.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.iya.rental.domain.entity.Role;
import com.iya.rental.domain.entity.User;
import com.iya.rental.domain.repository.RoleRepository;
import com.iya.rental.domain.repository.UserRepository;
import com.iya.rental.dto.request.UserRequest;
import com.iya.rental.dto.result.ResultVO;
import com.iya.rental.dto.result.UserResponse;
import com.iya.rental.enums.StatusCode;
import com.iya.rental.exception.UserException;
import com.iya.rental.validate.UpdateBCrypt;
import com.iya.rental.validate.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserValidator userValidator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    private static final UpdateBCrypt bcrypt = new UpdateBCrypt(11);

    public static String hash(String password) {
        return bcrypt.hash(password);
    }

    public UserResponse add(UserRequest reqVo){
        Role role = new Role();
        if (!reqVo.getRole().isEmpty()) {
            role = roleRepository.findByName(reqVo.getRole());
        }
        String messageValidation = userValidator.validateUser(reqVo);
         if (null != messageValidation) throw new UserException(messageValidation, HttpStatus.BAD_REQUEST, StatusCode.ERROR);
         String passwordHash= hash(reqVo.getPassword()); 
         User obj = new  User();
         Date date = new Date();
         obj.setCreatedBy("Aldian");
         obj.setCreationDate(date);
         obj.setName(reqVo.getName());
         obj.setAddress(reqVo.getAddress());
         obj.setEmail(reqVo.getEmail());
         obj.setPhone(reqVo.getPhone());
         obj.setPassword(passwordHash);
         obj.setRole_uuid(role.getUuid());
         
         userRepository.saveAndFlush(obj);
         
         log.info("added "+obj.getEmail());
         UserResponse resVo = new UserResponse();
         
         resVo.setUuid(obj.getUuid());
         resVo.setAddress(obj.getAddress());
         resVo.setName(obj.getName());
         resVo.setEmail(obj.getEmail());
         resVo.setPhone(obj.getPhone());
         resVo.setCreatedBy(obj.getCreatedBy());
         resVo.setCreationDate(obj.getCreationDate());
         resVo.setRoleId(role.getName());
 
         return resVo;
     }


     public UserResponse edit(UserRequest reqVo, String id){
        Role role = new Role();
        if (!reqVo.getRole().isEmpty()) {
            role = roleRepository.findByName(reqVo.getRole());
        }
        User user = userRepository.findByUuid(id);
        Date date = new Date();
        user.setModifiedBy("Aldian");
        user.setModificationDate(date);
        user.setName(reqVo.getName());
        user.setAddress(reqVo.getAddress());
        user.setPhone(reqVo.getPhone());
        user.setRole_uuid(role.getUuid());
         
        userRepository.saveAndFlush(user);
         
         log.info("added "+user.getEmail());
         UserResponse resVo = new UserResponse();
         
         resVo.setUuid(user.getUuid());
         resVo.setCreatedBy(user.getCreatedBy());
         resVo.setCreationDate(user.getCreationDate());
         resVo.setModifiedBy(user.getModifiedBy());
         resVo.setModificationDate(user.getCreationDate());
         resVo.setAddress(user.getAddress());
         resVo.setName(user.getName());
         resVo.setEmail(user.getEmail());
         resVo.setPhone(user.getPhone());
         resVo.setRoleId(role.getName());
 
         return resVo;
     }

     public ResultVO validate(UserRequest reqVo){
        User user = userRepository.findByEmail(reqVo.getEmail());
        if(bcrypt.verifyHash(reqVo.getPassword(), user.getPassword())){
            log.info("logged in "+user.getEmail());
            ResultVO resVo = new ResultVO();
            return resVo;
        }else{
            return null;
        }
     }

     public List<UserResponse> findAll(){
        List<User> user = userRepository.findByIsDeleteIsNullOrderByCreationDateDesc();
        List<UserResponse> responses = new ArrayList<>();
        
        for (User list : user) {
            UserResponse resVo = new UserResponse();
             resVo.setUuid(list.getUuid());
             resVo.setName(list.getName());
             resVo.setCreatedBy(list.getCreatedBy());
             resVo.setCreationDate(list.getCreationDate());
             resVo.setAddress(list.getAddress());
             resVo.setPhone(list.getPhone());
             resVo.setEmail(list.getEmail());
             resVo.setRoleId(list.getRole().getName());
           
            responses.add(resVo);
        }
        return responses;
    }


} 
