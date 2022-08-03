package com.iya.rental.dto.result;

import lombok.Data;

import java.util.Date;


@Data
public class UserResponse {

    private String uuid; 
    private String name;
    private String phone;
    private String email;
    private String address;
    private String createdBy;
    private Date creationDate;
    private String modifiedBy;
    private Date modificationDate;
    private Date isDelete;
    private String roleId;

    public UserResponse(){}
    public UserResponse(
                                String uuid,
                                String name,
                                String phone,
                                String email,
                                String address,
                                String createdBy,
                                Date creationDate,
                                String modifiedBy,
                                Date modificationDate,
                                Date isDelete,
                                String roleId){
        this.uuid = uuid;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.address=address;
        this.createdBy=createdBy;
        this.creationDate=creationDate;
        this.modifiedBy=modifiedBy;
        this.modificationDate=modificationDate;
        this.isDelete=isDelete;
        this.roleId=roleId;
    }
}
