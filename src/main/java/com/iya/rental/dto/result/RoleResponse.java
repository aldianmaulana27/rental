package com.iya.rental.dto.result;

import lombok.Data;



@Data
public class RoleResponse {

    private String uuid; 
    private String name;

    public RoleResponse(){}
    public RoleResponse(
                                String uuid,
                                String name){
        this.uuid = uuid;
        this.name=name;
    }
}
