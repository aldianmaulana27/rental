package com.iya.rental.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iya.rental.domain.entity.Image;
import com.iya.rental.domain.entity.ProductImage;
import com.iya.rental.domain.repository.ImageRepository;
import com.iya.rental.domain.repository.ProductImageRepository;
import com.iya.rental.dto.result.ImageResponse;
import com.iya.rental.util.ImageUtility;


@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

   @Autowired
   ProductImageRepository productImageRepository;
    public String add(MultipartFile file, String name, String type) throws IOException{

        imageRepository.save(Image.builder()
                .name(name)
                .type(file.getContentType())
                .category(type)
                .image(ImageUtility.compressImage(file.getBytes())).build());
                
        return "Image uploaded successfully: ";

     }

     public String addImageProduct(MultipartFile file, String name, String type, String productId) throws IOException{

      Image image = imageRepository.save(Image.builder()
              .name(name)
              .type(file.getContentType())
              .category(type)
              .image(ImageUtility.compressImage(file.getBytes())).build());

      ProductImage prodImage = productImageRepository.save(ProductImage.builder()
      .productId(productId)
      .imageId(image.getUuid()).build());
              
      return "Image uploaded successfully: ";

   }

     public Image getImageInfo (String name){
        Image dbImage = imageRepository.findByName(name);
        return dbImage;
     }

     public List<ImageResponse> getAllImages (String host){
         List<Image> dbImage = imageRepository.findByIsDeleteIsNull();
         List<ImageResponse> listImage = new ArrayList<>();
         for (Image list : dbImage) {
            ImageResponse image = new ImageResponse();
            image.setUuid(list.getUuid());
            image.setName(list.getName());
            image.setUrlImage(host+"/get/image/"+list.getUuid());
            image.setType(list.getType());
            listImage.add(image);
         }

         return listImage;
         
     }

     public List<ImageResponse> getImageCategory (String host,String category){
        List<Image> dbImage = imageRepository.findByCategory(category);
        List<ImageResponse> listImage = new ArrayList<>();
        for (Image list : dbImage) {
           ImageResponse image = new ImageResponse();
           image.setUuid(list.getUuid());
           image.setName(list.getName());
           image.setUrlImage(host+"/get/image/"+list.getUuid());
           image.setType(list.getType());
           listImage.add(image);
        }

        return listImage;
        
    }

     public Image getImage (String uuid){
        Image image = imageRepository.findByUuid(uuid);
        return image;
        
     }


} 
