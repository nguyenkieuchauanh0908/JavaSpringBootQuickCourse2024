package com.example.nobsv2.product.services;

import com.example.nobsv2.Query;
import com.example.nobsv2.product.ProductReposistory;
import com.example.nobsv2.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {

    private final ProductReposistory productReposistory;

    public SearchProductService(ProductReposistory productReposistory) {
        this.productReposistory = productReposistory;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        //JPA
//        return ResponseEntity.ok(productReposistory.findByNameContaining(name)
//                .stream()
//                .map(ProductDTO::new)
//                .toList());

        //JPQL
        return ResponseEntity.ok(productReposistory.findByNameOrDescriptionContaining(name)
        .stream()
        .map(ProductDTO::new)
        .toList());

    }
}
