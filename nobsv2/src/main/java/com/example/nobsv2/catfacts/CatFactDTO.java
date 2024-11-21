package com.example.nobsv2.catfacts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class CatFactDTO {
    private String catFact;


    public CatFactDTO(String fact) {
        this.catFact = fact;
    }
}
