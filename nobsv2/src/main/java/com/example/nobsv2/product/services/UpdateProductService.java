package com.example.nobsv2.product.services;

import com.example.nobsv2.Command;
import com.example.nobsv2.exception.ProductNotFoundException;
import com.example.nobsv2.product.ProductReposistory;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.model.UpdateProductCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private final ProductReposistory productReposistory;

    public UpdateProductService(ProductReposistory productReposistory) {
        this.productReposistory = productReposistory;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productReposistory.findById(command.getId());
        if (productOptional.isPresent()){
            Product product = command.getProduct();
            product.setId(command.getId());
            productReposistory.save(product); //either create new or update entity
            return ResponseEntity.ok(new ProductDTO(product));
        }

         throw new ProductNotFoundException();


    }
}
