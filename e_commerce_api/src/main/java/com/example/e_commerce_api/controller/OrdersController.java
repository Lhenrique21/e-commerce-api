package com.example.e_commerce_api.controller;

import com.example.e_commerce_api.dto.OrdersCreateDto;
import com.example.e_commerce_api.entity.Orders;
import com.example.e_commerce_api.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping("/create")
    public void createOrders(@RequestBody OrdersCreateDto  ordersCreateDto){
        ordersService.createOrder(ordersCreateDto);
    }

    @DeleteMapping("/delete")
    public void deleteOrders(@PathVariable Long id){
        ordersService.deleteOrder(id);
    }

    @GetMapping("/findById")
    public Orders findById(@PathVariable Long id){
        return ordersService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Orders> findAll(){
        return ordersService.findAll();
    }

    @GetMapping("/findByUserId")
    public Orders findByUserId(@PathVariable Long id){
        return ordersService.findByUserId(id);
    }

}
