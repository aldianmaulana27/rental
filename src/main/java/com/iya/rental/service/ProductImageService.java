package com.iya.rental.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iya.rental.domain.entity.Product;
import com.iya.rental.domain.entity.ProductImage;
import com.iya.rental.domain.repository.ImageRepository;
import com.iya.rental.domain.repository.ProductImageRepository;
import com.iya.rental.domain.repository.ProductRepository;
import com.iya.rental.dto.request.ProductRequest;
import com.iya.rental.dto.result.ProductImageResponse;

@Service
public class ProductImageService {


    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductRepository   productRepository;  

    @Autowired
    ProductImageRepository productImageRepository;

     public List<ProductImageResponse> getAllProductImage(String host, String uuid){

      List<ProductImage> products = productImageRepository.findByProductId(uuid);
      List<ProductImageResponse> product = new ArrayList<ProductImageResponse>();
      if(products.size() == 0){
        Product prod = productRepository.findByUuid(uuid);
        ProductImageResponse res = new ProductImageResponse();
        res.setUuid(prod.getUuid());
        res.setImageUrl(host+"/get/image/"+prod.getImage().getUuid());
        product.add(res);

      }else{
        for (ProductImage list : products ) {
            ProductImageResponse res = new ProductImageResponse();
            res.setUuid(list.getUuid());
            res.setImageUrl(host+"/get/image/"+list.getImage().getUuid());
            product.add(res);
        }
      }
      return product;

     }
  
} 
