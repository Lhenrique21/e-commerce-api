package com.example.e_commerce_api.dto;

import com.example.e_commerce_api.entity.OrdersItems;
import com.example.e_commerce_api.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrdersCreateDto {
    private Float total;
    private LocalDate date;
    private List<OrdersItemsCreateDto> ordersItems;
}
