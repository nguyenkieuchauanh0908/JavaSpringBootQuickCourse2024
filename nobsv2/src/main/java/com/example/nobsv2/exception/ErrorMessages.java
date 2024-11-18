package com.example.nobsv2.exception;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found");
    //can add to this list over time
    //messages all in one place

    private final String message;

    public String getMessage() {
        return message;
    }

    ErrorMessages(String message) {
        this.message = message;
    }
}
