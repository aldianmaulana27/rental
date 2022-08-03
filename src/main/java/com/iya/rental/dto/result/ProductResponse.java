package com.iya.rental.dto.result;

import lombok.Data;


@Data
public class ProductResponse {

    private String uuid; 
    private String name;
    private Integer year;
    private String color;
    private Integer capacity;
    private String gas;
    private String transmission;
    private String weekdayPrice;
    private String weekendPrice;
    private String imageId;
    
    public ProductResponse(){

    }
    public ProductResponse(String uuid, 
                        String name,
                        Integer year,
                        String color,
                        Integer capacity,
                        String gas,
                        String transmission,
                        String weekdayPrice,
                        String weekendPrice,
                        String imageId){
        this.uuid = uuid;
        this.name = name;
        this.year = year;
        this.color = color;
        this.capacity = capacity;
        this.gas = gas;
        this.transmission = transmission;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.imageId = imageId;
    }
}
