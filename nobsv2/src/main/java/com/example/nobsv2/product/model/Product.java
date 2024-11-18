package com.example.nobsv2.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //maps java class to MySQL
@Data
@Table(name = "product")
public class Product {
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Id //all tables need a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generated id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;
}
