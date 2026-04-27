package com.example.e_commerce_api.mapper;

import com.example.e_commerce_api.dto.OrdersItemsCreateDto;
import com.example.e_commerce_api.entity.OrdersItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrdersItemsMapper {
    public OrdersItems mapOrdersItemsToEntityCreate(OrdersItemsCreateDto ordersItemsCreateDto) {
        OrdersItems ordersItems = new OrdersItems();
        ordersItems.setQuantity(ordersItemsCreateDto.getQuantity());
        ordersItems.setPrice(ordersItemsCreateDto.getPrice());

        return ordersItems;
    }
}
