package com.example.e_commerce_api.dto;

import com.example.e_commerce_api.entity.Orders;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserCreateDto {
    private String name;
    private String email;
    private String password;
    private List<Orders> ordersList;
}
