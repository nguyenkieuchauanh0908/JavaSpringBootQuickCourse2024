package com.example.nobsv2.product.services;

import com.example.nobsv2.Query;
import com.example.nobsv2.exception.ProductNotFoundException;
import com.example.nobsv2.product.ProductReposistory;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private final ProductReposistory productReposistory;

    public GetProductService(ProductReposistory productReposistory) {
        this.productReposistory = productReposistory;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional< Product> productOptional = this.productReposistory.findById(String.valueOf(input));
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        throw new ProductNotFoundException();

    }
}
