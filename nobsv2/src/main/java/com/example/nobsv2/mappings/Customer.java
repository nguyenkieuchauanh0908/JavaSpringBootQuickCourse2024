package com.example.nobsv2.mappings;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    //FetchType.EAGER: When getting a customer, it will automatically get the Address
    //FetchType.LAZY: When getting a customer, it won't automatically get the Address
    //CascadeType.ALL: If you update the customer, it will automatically update the address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
}