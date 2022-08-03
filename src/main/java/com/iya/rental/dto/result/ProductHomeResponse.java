package com.iya.rental.dto.result;

import lombok.Data;



@Data
public class ProductHomeResponse {

    private String uuid; 
    private String name;
    private Integer year;
    private String weekdayPrice;
    private String weekendPrice;
    private String imageUrl;
    
    public ProductHomeResponse(){

    }
    public ProductHomeResponse(String uuid, 
                        String name,
                        Integer year,
                        String weekdayPrice,
                        String weekendPrice,
                        String imageUrl){
        this.uuid = uuid;
        this.name = name;
        this.year = year;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.imageUrl = imageUrl;
    }
}
