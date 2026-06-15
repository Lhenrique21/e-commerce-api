package com.example.e_commerce_api.repository;

import com.example.e_commerce_api.entity.OrdersItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersItemsRepository extends JpaRepository<OrdersItems, Long> {
}
