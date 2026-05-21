package com.example.e_commerce_api.repository;

import com.example.e_commerce_api.entity.Cart;
import com.example.e_commerce_api.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
    Optional<CartItems> deleteByCart(Cart cart);
}
