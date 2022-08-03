package com.iya.rental.dto.result;

import lombok.Data;

@Data
public class ImageResponse {

    private String uuid; 
    private String name;
    private String type;
    private String urlImage;

    public ImageResponse(){}
    public ImageResponse(
                                String uuid,
                                String name,
                                String type,
                                String urlImage){
        this.uuid = uuid;
        this.name=name;
        this.type=type;
        this.urlImage=urlImage;
    }
}
