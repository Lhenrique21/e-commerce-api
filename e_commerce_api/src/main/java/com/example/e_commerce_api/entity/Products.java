package com.example.e_commerce_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =  150, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String description;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Float stock;

    @OneToMany(mappedBy = "products")
    private List<CartItems> cartItems;

    @OneToMany(mappedBy = "products")
    private List<OrdersItems>  ordersItems;
}
