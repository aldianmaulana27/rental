package com.iya.rental.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iya.rental.dto.request.UserRequest;
import com.iya.rental.dto.result.ResultVO;
import com.iya.rental.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/user/api")
public class UserController {
       
    @Autowired
    UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody UserRequest vo){
      AbstractRequestHandler handler = new AbstractRequestHandler(){
        
        Object  result =userService.add(vo);
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

    @PutMapping("/edit")
    @ResponseBody
    public ResponseEntity<ResultVO> edit(@RequestBody UserRequest vo,@RequestParam String id){
      AbstractRequestHandler handler = new AbstractRequestHandler(){
        
        Object  result =userService.edit(vo,id);
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

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<ResultVO> verify(@RequestBody UserRequest vo){
      AbstractRequestHandler handler = new AbstractRequestHandler(){
        Object  result =userService.validate(vo);
        @Override
        public HttpStatus processStatus() {
            return result!=null ? HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
        }
    
        @Override
        public Object processRequest() {
               return "";
        }
    
        @Override
        public String processMessage() {
            return result != null ? "Success verified" : "failed to Adding Data";
        }
      };
        return handler.getResult();
    }

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<ResultVO> get(){
        AbstractRequestHandler handler = new AbstractRequestHandler(){
            Object  result =userService.findAll();
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
