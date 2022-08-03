package com.iya.rental.dto.result;

import lombok.Data;

@Data
public class UserGetResponse {

    private String uuid;
    private String name;
    private String phone;
    private String email;
    private String address;

    public UserGetResponse(){}
    public UserGetResponse(
                                String uuid,
                                String name,
                                String phone,
                                String email,
                                String address){
        this.uuid=uuid;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.address=address;
        
    }

}
