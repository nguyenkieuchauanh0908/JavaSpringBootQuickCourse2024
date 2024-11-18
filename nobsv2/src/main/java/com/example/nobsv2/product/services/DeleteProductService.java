package com.example.nobsv2.product.services;

import com.example.nobsv2.Command;
import com.example.nobsv2.exception.ProductNotFoundException;
import com.example.nobsv2.product.ProductReposistory;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {

    private final ProductReposistory productReposistory;

    public DeleteProductService(ProductReposistory productReposistory) {
        this.productReposistory = productReposistory;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Product> productOptional = productReposistory.findById(String.valueOf(id));
        if(productOptional.isPresent()){
            productReposistory.deleteById(String.valueOf(id));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new ProductNotFoundException();

    }
}
