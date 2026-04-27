package com.example.e_commerce_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemsUpdateDto extends CartItemsCreateDto {
    private Long id;
}
