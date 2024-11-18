package com.example.nobsv2.product.services;

import com.example.nobsv2.Query;
import com.example.nobsv2.product.ProductReposistory;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<ProductDTO>> {

    private final ProductReposistory productReposistory;

    public GetProductsService(ProductReposistory productReposistory) {
        this.productReposistory = productReposistory;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<Product> products = productReposistory.findAll();
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();
        // don't throw any exception. If none was found => return empty list
        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }
}
