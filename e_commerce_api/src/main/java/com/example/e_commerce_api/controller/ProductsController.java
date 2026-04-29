package com.example.e_commerce_api.controller;

import com.example.e_commerce_api.dto.ProductsCreateDto;
import com.example.e_commerce_api.dto.ProductsUpdateDto;
import com.example.e_commerce_api.entity.Products;
import com.example.e_commerce_api.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    @PostMapping("/create")
    public void createProducts(@RequestBody ProductsCreateDto productsCreateDto){
        productsService.createProducts(productsCreateDto);
    }

    @GetMapping("/findById")
    public Products findById(@PathVariable Long id){
        return productsService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Products> findAll(){
        return productsService.findAll();
    }

    @GetMapping("/findByName")
    public Products findByName(@PathVariable String name){
        return productsService.findByName(name);
    }

    @PutMapping("/update")
    public void updateProducts(@RequestBody ProductsUpdateDto productsUpdateDto){
        productsService.updateProducts(productsUpdateDto);
    }

    @DeleteMapping("/delete")
    public void deleteProducts(@PathVariable Long id){
        productsService.deleteById(id);
    }
}
