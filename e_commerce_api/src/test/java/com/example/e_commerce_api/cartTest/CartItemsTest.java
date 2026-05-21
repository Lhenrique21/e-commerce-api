package com.example.e_commerce_api.cartTest;

import com.example.e_commerce_api.dto.CartItemsCreateDto;
import com.example.e_commerce_api.dto.CartItemsUpdateDto;
import com.example.e_commerce_api.dto.CartUpdateDto;
import com.example.e_commerce_api.entity.Cart;
import com.example.e_commerce_api.entity.CartItems;
import com.example.e_commerce_api.entity.Products;

public class CartItemsTest {

    public static CartItemsCreateDto cartItemsCreateDto(){
        CartItemsCreateDto cartItemsCreateDto = new CartItemsCreateDto();
        cartItemsCreateDto.setQuantity(1F);
        return cartItemsCreateDto;
    }

    public static CartItems cartItems(){
        CartItems cartItems = new CartItems();
        cartItems.setCart(new Cart());
        cartItems.setProducts(new Products());
        cartItems.setQuantity(1F);
        return cartItems;
    }

    public static CartItemsUpdateDto cartItemsUpdateDto(){
        CartItemsUpdateDto cartItemsUpdateDto = new CartItemsUpdateDto();
        cartItemsUpdateDto.setQuantity(1F);
        cartItemsUpdateDto.setId(1L);
        return cartItemsUpdateDto;
    }



}
