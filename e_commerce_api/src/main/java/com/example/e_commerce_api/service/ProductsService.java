package com.example.e_commerce_api.service;

import com.example.e_commerce_api.dto.ProductsCreateDto;
import com.example.e_commerce_api.dto.ProductsUpdateDto;
import com.example.e_commerce_api.entity.Products;
import com.example.e_commerce_api.exception.ProductsException;
import com.example.e_commerce_api.mapper.ProductsMapper;
import com.example.e_commerce_api.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public void createProducts(ProductsCreateDto productsCreateDto){
        try{
            Products products = ProductsMapper.mapProductsToEntityCreate(productsCreateDto);
            productsRepository.save(products);
        } catch (Exception e){
            throw new ProductsException("Erro ao criar produto" + e.getMessage());
        }
    }

    public Products findById(Long id){
        try{return productsRepository.findById(id).get();

        } catch (Exception e) {
            throw new ProductsException("Erro ao buscar produto pelo ID " + e.getMessage());
        }
    }

    public List<Products> findAll(){
        try{
            return productsRepository.findAll();
        } catch (Exception e) {
            throw new ProductsException("Erro ao buscar produtos " + e.getMessage());
        }
    }

    public Products findByName(String name){
        try {
         Products products = productsRepository.findByName(name).get();
         return products;
        } catch (Exception e) {
            throw new ProductsException("Erro ao buscar produto pelo nome " + e.getMessage());
        }
    }

    public void updateProducts(ProductsUpdateDto productsUpdateDto){
        try {
            Optional<Products> optionalProducts = productsRepository.findById(productsUpdateDto.getId());
            if (optionalProducts.isPresent()){
                Products products = optionalProducts.get();
                products.setName(productsUpdateDto.getName());
                products.setPrice(productsUpdateDto.getPrice());
                products.setDescription(productsUpdateDto.getDescription());
                products.setStock(productsUpdateDto.getStock());
                productsRepository.save(products);
            }
        } catch (Exception e) {
            throw new ProductsException("Erro ao atualizar produto " + e.getMessage());
        }
    }

    public void deleteById(Long id){
        try{
            productsRepository.deleteById(id);
        } catch (Exception e) {
            throw new ProductsException("Erro ao deletar produto " + e.getMessage());
        }
    }
}
