package com.example.e_commerce_api.mapper;

import com.example.e_commerce_api.dto.OrdersCreateDto;
import com.example.e_commerce_api.entity.Orders;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrdersMapper {

    public Orders mapOrdersToEntityCreate(OrdersCreateDto ordersCreateDto) {
        Orders orders = new Orders();
        orders.setTotal(ordersCreateDto.getTotal());
        orders.setCreated_at(ordersCreateDto.getDate());

        return orders;
    }
}
