package com.example.nobsv2.product.model;

import lombok.Getter;

@Getter
public class UpdateProductCommand {
    private final Integer id;
    private final Product product;

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public UpdateProductCommand(Integer id, Product product) {
        this.id = id;
        this.product = product;
    }
}
