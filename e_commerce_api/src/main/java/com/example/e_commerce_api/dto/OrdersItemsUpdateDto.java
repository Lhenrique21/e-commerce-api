package com.example.e_commerce_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersItemsUpdateDto extends OrdersItemsCreateDto {
    private Long id;
}
