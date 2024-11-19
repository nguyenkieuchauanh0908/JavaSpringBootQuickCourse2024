package com.example.nobsv2;

import com.example.nobsv2.exception.ProductNotFoundException;
import com.example.nobsv2.product.ProductReposistory;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.services.GetProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetProductServiceTest {
    @Mock // what to mock the response of -> need this dependency to run the test
    private ProductReposistory productReposistory;

    @InjectMocks //the class we are testing
    private GetProductService getProductService;

    @BeforeEach //things we need before test run to set up properly
    public void setUp(){
        //initialize the repository & the service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_product_exists_when_get_product_service_return_productDTO(){
        //Given
        Product product = new Product();
        product.setId(1);
        product.setName("Product name");
        product.setDescription("Product description which is at least 20 chars");
        product.setPrice(9.99);
        //this says when but it's actually still setting up
        when(productReposistory.findById(1)).thenReturn(Optional.of(product));

        //When
        ResponseEntity<ProductDTO> response = getProductService.execute(1);

        //Then
        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response);
        //assert the product repository only called once
        verify(productReposistory, times(1)).findById(1);
    }

    @Test
    public void given_product_does_not_exist_when_get_product_service_throw_product_not_found_exception(){
        //Given
        when(productReposistory.findById(1)).thenReturn(Optional.empty());


        //When & Then
        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productReposistory, times(1)).findById(1);
    }
}
