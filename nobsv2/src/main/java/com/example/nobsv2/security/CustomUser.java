package com.example.nobsv2.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="custom_user")
@Data
public class CustomUser {
    // No-argument constructor
    public CustomUser() {}

    public CustomUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Id
    @Column(name = "username")
    private String username;

    @Column(name="password")
    private String password;

}