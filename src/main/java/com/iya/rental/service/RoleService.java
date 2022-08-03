package com.iya.rental.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iya.rental.domain.entity.Role;
import com.iya.rental.domain.repository.RoleRepository;
import com.iya.rental.dto.request.RoleRequest;
import com.iya.rental.dto.result.RoleResponse;


@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;


    public RoleResponse add(RoleRequest reqVo){
         Role obj = new  Role();
         obj.setName(reqVo.getName());
         roleRepository.saveAndFlush(obj);
         
         RoleResponse resVo = new RoleResponse();
         
         resVo.setUuid(obj.getUuid());
         resVo.setName(obj.getName()); 
         return resVo;
     }

     public List<RoleResponse> findAll(){
        List<Role> role = roleRepository.findByIsDeleteIsNull();
        List<RoleResponse> responses = new ArrayList<>();

        for (Role list : role) {
            RoleResponse resVo = new RoleResponse();
             resVo.setUuid(list.getUuid());
             resVo.setName(list.getName());
           
            responses.add(resVo);
        }
        return responses;
    }

} 
