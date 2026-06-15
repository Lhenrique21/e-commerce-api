package com.example.e_commerce_api.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_orders_items")
public class OrdersItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;

    @Column(nullable = false)
    private Float quantity;

    @Column(nullable = false)
    private Float price;
}
