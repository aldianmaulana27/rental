package com.iya.rental.dto.result;

import lombok.Data;



@Data
public class ProductImageResponse {

    private String uuid; 
    private String imageUrl;
    
    public ProductImageResponse(){

    }
    public ProductImageResponse(String uuid, 
                        String imageUrl){
        this.uuid = uuid;
        this.imageUrl = imageUrl;
    }
}
