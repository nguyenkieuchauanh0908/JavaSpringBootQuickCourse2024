package com.example.nobsv2.product.services;

import com.example.nobsv2.Command;
import com.example.nobsv2.exception.ErrorMessages;
import com.example.nobsv2.exception.ProductNotValidException;
import com.example.nobsv2.product.ProductReposistory;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.validattors.ProductValidator;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductReposistory productReposistory;

    public CreateProductService(ProductReposistory productReposistory) {
        this.productReposistory = productReposistory;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
//        ProductValidator.execute(product);
        Product savedProduct = productReposistory.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }


}
