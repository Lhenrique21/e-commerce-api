package com.example.e_commerce_api.repository;

import com.example.e_commerce_api.entity.Cart;
import com.example.e_commerce_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByUserId(Long id);
}
