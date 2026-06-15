package com.example.e_commerce_api.mapper;

import com.example.e_commerce_api.dto.CartItemsCreateDto;
import com.example.e_commerce_api.entity.CartItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CartItemsMapper {
    public CartItems mapCartItemsToEntityCreate(CartItemsCreateDto cartItemsCreateDto) {
        CartItems cartItems = new CartItems();
        cartItems.setQuantity(cartItemsCreateDto.getQuantity());
        return cartItems;
    }
}
