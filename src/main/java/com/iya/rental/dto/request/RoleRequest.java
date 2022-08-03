package com.iya.rental.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RoleRequest {

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("name")
    private String name;


    public RoleRequest(){

    }
    public RoleRequest(String uuid, 
                         String name){
        this.uuid = uuid;
        this.name = name;
    }
}