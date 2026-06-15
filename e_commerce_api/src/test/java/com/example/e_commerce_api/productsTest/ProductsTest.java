package com.example.e_commerce_api.productsTest;

import com.example.e_commerce_api.dto.ProductsCreateDto;
import com.example.e_commerce_api.dto.ProductsUpdateDto;
import com.example.e_commerce_api.entity.Products;

public class ProductsTest {

    public static ProductsCreateDto productsCreateDto(){
        ProductsCreateDto productsCreateDto = new ProductsCreateDto();
        productsCreateDto.setName("Test name");
        productsCreateDto.setDescription("Test description");
        productsCreateDto.setPrice(150F);
        productsCreateDto.setStock(500F);
        return productsCreateDto;
    }

    public static Products products(){
        Products products = new Products();
        products.setName("Test name");
        products.setDescription("Test description");
        products.setPrice(150F);
        products.setStock(500F);
        return products;
    }

    public static ProductsUpdateDto  productsUpdateDto(){
        ProductsUpdateDto productsUpdateDto = new ProductsUpdateDto();
        productsUpdateDto.setId(1L);
        productsUpdateDto.setName("Test name");
        productsUpdateDto.setDescription("Test description");
        productsUpdateDto.setPrice(150F);
        productsUpdateDto.setStock(500F);
        return productsUpdateDto;
    }
}
