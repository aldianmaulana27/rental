package com.iya.rental.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iya.rental.dto.result.ResultVO;
import com.iya.rental.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value = "/product/api")
public class ProductController {
       
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestParam("image") MultipartFile file,@RequestParam("imageName") String imageName,@RequestParam("imageType") String imageType,
    @RequestParam("name") String name,@RequestParam("year") String year,@RequestParam("color") String color,@RequestParam("capacity") String capacity,
    @RequestParam("gas") String gas,@RequestParam("transmission") String transmission,@RequestParam("weekdayPrice") String weekdayPrice,@RequestParam("weekendPrice") String weekendPrice) throws IOException{
      AbstractRequestHandler handler = new AbstractRequestHandler(){
        
        String result =productService.add(file, imageName, imageType, name, year, color, capacity, gas, transmission, weekdayPrice, weekendPrice);
        
        
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


    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<ResultVO> get(HttpServletRequest request){
        String host = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort();
        System.out.println(host);    

        AbstractRequestHandler handler = new AbstractRequestHandler(){
            Object  result =productService.getAllProduct(host);
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

    @GetMapping("/getProductById")
    @ResponseBody
    public ResponseEntity<ResultVO> getProductById(HttpServletRequest request,@RequestParam("id") String id){
        String host = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort();
        System.out.println(host);    

        AbstractRequestHandler handler = new AbstractRequestHandler(){
            Object  result =productService.getProductById(host, id);
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
