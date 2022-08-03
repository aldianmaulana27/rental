package com.iya.rental.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductRequest {

    
    @JsonProperty("uuid")
    private String uuid; 

    @JsonProperty("name")
    private String name;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("color")
    private String color;

    @JsonProperty("capacity")
    private Integer capacity;

    @JsonProperty("gas")
    private String gas;

    @JsonProperty("transmission")
    private String transmission;

    @JsonProperty("weekday_price")
    private String weekdayPrice;

    @JsonProperty("weekend_price")
    private String weekendPrice;

    @JsonProperty("product_image_uuid")
    private String productImageId;

    @JsonProperty("image_uuid")
    private String imageId;

    

    public ProductRequest(){

    }
    public ProductRequest(String uuid, 
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