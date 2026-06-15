package com.example.e_commerce_api.repository;

import com.example.e_commerce_api.entity.Orders;
import com.example.e_commerce_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findByUserId (Long id);
}
