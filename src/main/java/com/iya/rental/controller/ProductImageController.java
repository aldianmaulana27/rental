package com.iya.rental.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iya.rental.dto.result.ResultVO;
import com.iya.rental.service.ProductImageService;

import lombok.NoArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping(value = "/product-image/api")
public class ProductImageController {
       
    @Autowired
    ProductImageService productImageService;


    @GetMapping("/getImageProductById")
    @ResponseBody
    public ResponseEntity<ResultVO> getProductById(HttpServletRequest request,@RequestParam("productId") String id){
        String host = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort();
        System.out.println(host);    

        AbstractRequestHandler handler = new AbstractRequestHandler(){
            Object  result =productImageService.getAllProductImage(host, id);
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
