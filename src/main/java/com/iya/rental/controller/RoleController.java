package com.iya.rental.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iya.rental.dto.request.RoleRequest;
import com.iya.rental.dto.result.ResultVO;
import com.iya.rental.service.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/role/api")
public class RoleController {
       
    @Autowired
    RoleService roleService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody RoleRequest vo){
      AbstractRequestHandler handler = new AbstractRequestHandler(){
        
        Object  result =roleService.add(vo);
        @Override
        public HttpStatus processStatus() {
            return result!=null ? HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
        }
    
        @Override
        public Object processRequest() {
               return result;
        }
    
        @Override
        public String processMessage() {
            return result != null ? "Data Added" : "failed to Adding Data";
        }
      };
        return handler.getResult();
    }


    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<ResultVO> get(){
        AbstractRequestHandler handler = new AbstractRequestHandler(){
            Object  result =roleService.findAll();
            @Override
            public HttpStatus processStatus() {
                return result!=null ? HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
            }
        
            @Override
            public Object processRequest() {
                   return result;
            }
        
            @Override
            public String processMessage() {
                return result != null ? "Data Success" : "failed to Getting Data";
            }
        };
        return handler.getResult();
    }
} 
