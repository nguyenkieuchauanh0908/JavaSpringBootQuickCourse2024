package com.example.nobsv2.product;

import com.example.nobsv2.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReposistory extends JpaRepository<Product,String> {

}