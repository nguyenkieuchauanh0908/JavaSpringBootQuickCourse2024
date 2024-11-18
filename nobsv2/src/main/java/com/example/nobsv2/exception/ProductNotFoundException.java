package com.example.nobsv2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//This is the first way of throwing error if you want to go with default Java Exception handler
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
    }
}
