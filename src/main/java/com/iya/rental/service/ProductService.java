package com.iya.rental.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iya.rental.domain.entity.Image;
import com.iya.rental.domain.entity.Product;
import com.iya.rental.domain.repository.ImageRepository;
import com.iya.rental.domain.repository.ProductImageRepository;
import com.iya.rental.domain.repository.ProductRepository;
import com.iya.rental.dto.result.ProductHomeResponse;
import com.iya.rental.util.ImageUtility;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductImageRepository productImageRepository;

    public String add(MultipartFile file, String imageName, String imageType,
    String name,
    String year,
    String color,
    String capacity,
    String gas,
    String transmission,
    String weekdayPrice,
    String weekendPrice) throws IOException{

        Image image =  imageRepository.save(Image.builder()
                .name(imageName)
                .type(file.getContentType())
                .category(imageType)
                .image(ImageUtility.compressImage(file.getBytes())).build());
         
         Product product = productRepository.save(Product.builder()
         .name(name)
         .year(Integer.parseInt(year))
         .color(color)
         .capacity(Integer.parseInt(capacity))
         .gas(gas)
         .transmission(transmission)
         .weekdayPrice(weekdayPrice)
         .weekendPrice(weekendPrice)
         .imageId(image.getUuid()).build());

         return "success";
     }

     public List<ProductHomeResponse> getAllProduct(String host){

      List<Product> products = productRepository.findByIsDeleteIsNullOrderByCreationDateDesc();
      List<ProductHomeResponse> product = new ArrayList<ProductHomeResponse>();
      for (Product list : products ) {
         ProductHomeResponse res = new ProductHomeResponse();
         res.setUuid(list.getUuid());
         res.setName(list.getName());
         res.setWeekdayPrice(list.getWeekdayPrice());
         res.setWeekendPrice(list.getWeekendPrice());
         res.setYear(list.getYear());
         res.setImageUrl(host+"/get/image/"+list.getImage().getUuid());
         product.add(res);
      }
      return product;

     }


     public ProductHomeResponse getProductById(String host, String id){

        Product products = productRepository.findByUuid(id);
           ProductHomeResponse res = new ProductHomeResponse();
           res.setUuid(products.getUuid());
           res.setName(products.getName());
           res.setWeekdayPrice(products.getWeekdayPrice());
           res.setWeekendPrice(products.getWeekendPrice());
           res.setYear(products.getYear());
           res.setImageUrl(host+"/get/image/"+products.getImage().getUuid());

           return res;
  
       }
  
} 
