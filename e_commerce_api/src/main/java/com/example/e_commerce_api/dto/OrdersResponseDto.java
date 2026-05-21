package com.example.e_commerce_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrdersResponseDto {
    private Long id;
    private Float total;
    private LocalDate date;
    private List<OrdersItemsResponseDto> ordersItems;
}
