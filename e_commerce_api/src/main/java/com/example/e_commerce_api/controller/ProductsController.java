package com.example.e_commerce_api.controller;

import com.example.e_commerce_api.dto.ProductsCreateDto;
import com.example.e_commerce_api.dto.ProductsUpdateDto;
import com.example.e_commerce_api.entity.Products;
import com.example.e_commerce_api.service.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Produtos", description = "Endpoints para gerenciamento dos produtos")
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    @Operation(summary = "Cria produto", description = "Recebe um DTO para criar o produto")
    @PostMapping("/create")
    public void createProducts(@RequestBody ProductsCreateDto productsCreateDto) {
        productsService.createProducts(productsCreateDto);
    }

    @Operation(summary = "Busca o produto pelo ID", description = "Recebe um ID para buscar o produto")
    @GetMapping("/findById/{id}")
    public Products findById(@PathVariable Long id) {
        return productsService.findById(id);
    }

    @Operation(summary = "Busca todos os produtos", description = "Retorna todos os usuários")
    @GetMapping("/findAll")
    public List<Products> findAll() {
        return productsService.findAll();
    }

    @Operation(summary = "Busca o produto pelo nome", description = "Recebe o nome para buscar o produto")
    @GetMapping("/findByName/{name}")
    public Products findByName(@PathVariable String name) {
        return productsService.findByName(name);
    }

    @Operation(summary = "Atualiza o produto", description = "Atualiza o usuário de acordo com o ID")
    @PutMapping("/update")
    public void updateProducts(@RequestBody ProductsUpdateDto productsUpdateDto) {
        productsService.updateProducts(productsUpdateDto);
    }

    @Operation(summary = "Deleta o produto", description = "Recebe um ID para deletar o produto")
    @DeleteMapping("/delete/{id}")
    public void deleteProducts(@PathVariable Long id) {
        productsService.deleteById(id);
    }
}
