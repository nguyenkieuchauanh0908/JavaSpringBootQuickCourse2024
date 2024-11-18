package com.example.nobsv2.exception;

import com.example.nobsv2.product.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//Besides adding exception handler in the controllers, you can also add them all into one global file as bellow
@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException exception){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(exception.getMessage()));
//    }

@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public ErrorResponse handleProductNotFoundException(ProductNotFoundException exception){
    return new ErrorResponse(exception.getMessage());
}

//Can add more exception handlers
}
