package com.example.nobsv2.exception;

import com.example.nobsv2.product.services.GetProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//This is the first way of throwing error if you want to go with default Java Exception handler
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(GetProductService.class);
    public ProductNotFoundException() {
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
        logger.error("Exception " + getClass() + " thrown");
    }
}
