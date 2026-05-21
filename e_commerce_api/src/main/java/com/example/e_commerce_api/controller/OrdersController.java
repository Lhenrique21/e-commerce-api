package com.example.e_commerce_api.controller;

import com.example.e_commerce_api.dto.OrdersCreateDto;
import com.example.e_commerce_api.dto.OrdersResponseDto;
import com.example.e_commerce_api.entity.Orders;
import com.example.e_commerce_api.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Pedidos", description = "Endpoints para gerenciamentos dos pedidos")
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Operation(summary = "Cria pedido", description = "Recebe o ID e um DTO para criar o pedido")
    @PostMapping("/create/{idUser}")
    public void createOrders(@PathVariable Long idUser, @RequestBody OrdersCreateDto ordersCreateDto) {
        ordersService.createOrder(idUser, ordersCreateDto);
    }

    @Operation(summary = "Deleta pedido", description = "Recebe o ID e deleta o pedido")
    @DeleteMapping("/delete/{id}")
    public void deleteOrders(@PathVariable Long id) {
        ordersService.deleteOrder(id);
    }

    @Operation(summary = "Busca o pedido pelo ID", description = "Recebe um ID e pega o pedido")
    @GetMapping("/findById/{id}")
    public Orders findById(@PathVariable Long id) {
        return ordersService.findById(id);
    }

    @Operation(summary = "Busca todos os pedidos", description = "Retorna todos os pedidos")
    @GetMapping("/findAll")
    public List<Orders> findAll() {
        return ordersService.findAll();
    }

    @Operation(summary = "Busca o pedido pelo usuário", description = "Recebe o ID do usuário e retorna o pedido do usuário")
    @GetMapping("/findByUserId/{id}")
    public OrdersResponseDto findByUserId(@PathVariable Long id) {
        return ordersService.findByUserId(id);
    }

}
