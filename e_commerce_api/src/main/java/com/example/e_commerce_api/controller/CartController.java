package com.example.e_commerce_api.controller;

import com.example.e_commerce_api.dto.ProductsCreateDto;
import com.example.e_commerce_api.dto.ProductsUpdateDto;
import com.example.e_commerce_api.entity.Products;
import com.example.e_commerce_api.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Tag(name = "Carrinho", description = "Endpoints para gerenciamento dos carrinhos")
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Operation(summary = "Adiciona um produto ao carrinho", description = "Recebe o id do usuário e o id do produto para adicionar ao carrinho")
    @PostMapping("/addProductToCart/{idUser}")
    public void addProductToCart(@PathVariable Long idUser, @RequestBody ProductsUpdateDto idProduct){
        cartService.addProductToCart(idUser, idProduct.getId(), idProduct.getQuantity());
    }

    @Operation(summary = "Remove um produto do carrinho", description = "Recebe o id do usuário e o id do produto e remove do carrinho")
    @DeleteMapping("/removeProductFromCart/{idUser}")
    public void removeProductFromCart(@PathVariable Long idUser,@RequestBody ProductsUpdateDto idProduct){
        cartService.removeProductsFromCart(idUser, idProduct.getId(),  idProduct.getQuantity());
    }

    @Operation(summary = "Limpa o carrinho", description = "Recebe o id do usuário e limpa o carrinho")
    @DeleteMapping("/cleanCart/{idUser}")
    public void cleanCart(@PathVariable Long idUser){
        cartService.cleanCart(idUser);
    }
}
