package com.example.e_commerce_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrdersCreateDto {
    private Float total;
    private LocalDate date;
}
