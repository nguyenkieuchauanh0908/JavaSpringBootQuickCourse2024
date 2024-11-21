package com.example.nobsv2.catfacts;

import lombok.Data;

@Data
public class CatFactResponse {
    private String fact;

    public String getFact() {
        return fact;
    }

    private int length;
}
