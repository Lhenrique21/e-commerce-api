package com.example.e_commerce_api.service;

import com.example.e_commerce_api.exception.CartException;
import com.example.e_commerce_api.repository.CartRepository;
import com.example.e_commerce_api.repository.ProductsRepository;
import com.example.e_commerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public void cleanCart(){
        try{
            cartRepository.deleteAll();
        } catch (Exception e) {
            throw new CartException("Erro ao limpar carrinho " + e.getMessage());
        }
    }
}
