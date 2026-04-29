package com.example.e_commerce_api.controller;

import com.example.e_commerce_api.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/addProductToCart")
    public void addProductToCart(@PathVariable Long idUser, @PathVariable Long idProduct){
        cartService.addProductToCart(idUser, idProduct);
    }

    @DeleteMapping("/removeProductFromCart")
    public void removeProductFromCart(@PathVariable Long idUser, @PathVariable Long idProduct){
        cartService.removeProductsFromCart(idUser, idProduct);
    }

    @DeleteMapping("/cleanCart")
    public void cleanCart(){
        cartService.cleanCart();
    }
}
