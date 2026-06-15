package com.example.e_commerce_api.mapper;

import com.example.e_commerce_api.dto.CartUpdateDto;
import com.example.e_commerce_api.entity.Cart;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CartMapper {

    public Cart mapCartToEntityCreate(CartUpdateDto cartUpdateDto) {
        Cart cart = new Cart();
        cart.setId(cartUpdateDto.getId());

        return cart;
    }
}
