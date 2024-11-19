package com.example.nobsv2.exception;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found"),
    NAME_REQUIRED("Product's name is required!"),
    DESCRIPTION_LENGTH("Description must be 20 characters length!"),
    PRICE_CANNOT_BE_NEGATIVE("Price can not be negative or emptied!");

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
