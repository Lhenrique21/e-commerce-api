package com.example.e_commerce_api.ordersTest;

import com.example.e_commerce_api.dto.OrdersCreateDto;
import com.example.e_commerce_api.dto.OrdersUpdateDto;
import com.example.e_commerce_api.entity.Orders;
import com.example.e_commerce_api.entity.User;

import java.time.LocalDate;

public class OrdersTest {

    public static OrdersCreateDto ordersCreateDto(){
        OrdersCreateDto ordersCreateDto = new OrdersCreateDto();
        ordersCreateDto.setDate(LocalDate.now());
        ordersCreateDto.setTotal(150F);
        return ordersCreateDto;
    }

    public static Orders orders(){
        Orders orders = new Orders();
        orders.setUser(new User());
        orders.setCreated_at(LocalDate.now());
        orders.setTotal(150F);
        return orders;
    }

    public static OrdersUpdateDto  ordersUpdateDto(){
        OrdersUpdateDto ordersUpdateDto = new OrdersUpdateDto();
        ordersUpdateDto.setId(1L);
        ordersUpdateDto.setDate(LocalDate.now());
        ordersUpdateDto.setTotal(150F);
        return ordersUpdateDto;
    }
}
