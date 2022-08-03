package com.iya.rental.exception;

import org.springframework.http.HttpStatus;

import com.iya.rental.enums.StatusCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserException extends RuntimeException{

    private StatusCode code = null;
    private HttpStatus status = null;

    public UserException(){
        super();
    }

    public UserException(String message){
        super(message);
    }

    public UserException(String message, StatusCode code){
        super(message);
        this.code = code;
    }

    public UserException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public UserException(String message, HttpStatus status, StatusCode code){
        super(message);
        this.status = status;
        this.code = code;
    }

}