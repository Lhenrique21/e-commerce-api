package com.example.e_commerce_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsCreateDto {
    private String name;
    private String description;
    private Float price;
    private Float stock;
}
