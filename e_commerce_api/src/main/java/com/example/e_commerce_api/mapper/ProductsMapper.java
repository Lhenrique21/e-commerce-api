package com.example.e_commerce_api.mapper;

import com.example.e_commerce_api.dto.ProductsCreateDto;
import com.example.e_commerce_api.entity.Products;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductsMapper {

    public Products mapProductsToEntityCreate(ProductsCreateDto productsCreateDto){
        Products products = new Products();
        products.setName(productsCreateDto.getName());
        products.setDescription(productsCreateDto.getDescription());
        products.setPrice(productsCreateDto.getPrice());
        products.setStock(productsCreateDto.getStock());

        return products;
    }
}
