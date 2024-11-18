package com.example.nobsv2.product.model;

import lombok.Getter;

//This is the second way of throwing error exception if you want to build your own one
@Getter
public class ErrorResponse {
    //More properties customized as you go
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
