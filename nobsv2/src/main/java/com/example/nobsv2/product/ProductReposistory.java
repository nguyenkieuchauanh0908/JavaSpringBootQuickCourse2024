package com.example.nobsv2.product;

import com.example.nobsv2.product.model.Product;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReposistory extends JpaRepository<Product,Integer> {

    //spring data jpa
    List<Product> findByNameContaining(String name);

    //JPQL (Java Persistence Query Language)
    @Query("Select p FROM Product p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
    List<Product> findByNameOrDescriptionContaining(@Param("keyword") String name);

    //You can also use custom native query with mySQL query (but as the last resort...)
}
