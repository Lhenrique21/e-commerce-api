package com.example.e_commerce_api.service;

import com.example.e_commerce_api.dto.*;
import com.example.e_commerce_api.entity.*;
import com.example.e_commerce_api.exception.OrdersException;
import com.example.e_commerce_api.mapper.OrdersMapper;
import com.example.e_commerce_api.repository.OrdersItemsRepository;
import com.example.e_commerce_api.repository.OrdersRepository;
import com.example.e_commerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrdersItemsRepository ordersItemsRepository;


    public Orders createOrder(Long idUser, OrdersCreateDto ordersCreateDto) {
        try {
            User user = userRepository.findById(idUser)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            Cart cart = user.getCart();
            if (cart == null || cart.getCartItems().isEmpty()) {
                throw new RuntimeException("Carrinho vazio!");
            }

            Orders orders = OrdersMapper.mapOrdersToEntityCreate(ordersCreateDto);
            orders.setUser(user);
            orders.setCreated_at(LocalDate.now());

            OrdersItems orderItem = new OrdersItems();
            List<OrdersItems> orderItems = cart.getCartItems().stream().map(cartItem -> {
                orderItem.setProducts(cartItem.getProducts());
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setPrice(cartItem.getProducts().getPrice());
                orderItem.setOrders(orders);
                return orderItem;
            }).collect(Collectors.toList());

            orders.setOrdersItems(orderItems);


            Orders savedOrder = ordersRepository.save(orders);
            ordersItemsRepository.save(orderItem);


            return savedOrder;
        } catch (Exception e) {
            throw new OrdersException("Erro ao criar pedido " + e.getMessage());
        }
    }

    public void deleteOrder(Long idOrder) {
        try {
            ordersRepository.deleteById(idOrder);
        } catch (Exception e) {
            throw new OrdersException("Erro ao deletar pedido " + e.getMessage());
        }
    }

    public Orders findById(Long idOrder) {
        try {
            return ordersRepository.findById(idOrder).get();
        } catch (Exception e) {
            throw new OrdersException("Erro ao buscar pedido pelo ID " + e.getMessage());
        }
    }

    public List<Orders> findAll() {
        try {
            return ordersRepository.findAll();
        } catch (Exception e) {
            throw new OrdersException("Erro ao buscar pedidos " + e.getMessage());
        }
    }

    public OrdersResponseDto findByUserId(Long idUser) {
        try {
            // 1. Busca a Entidade pura do banco de dados
            Orders orders = ordersRepository.findByUserId(idUser).get();

            // 2. Converte a lista de Entidades (OrdersItems) para a lista de DTOs (OrdersItemsResponseDto)
            List<OrdersItemsResponseDto> itemsResponseDto = orders.getOrdersItems().stream()
                    .map(item -> {
                        OrdersItemsResponseDto itemDto = new OrdersItemsResponseDto();
                        itemDto.setId(item.getId());
                        itemDto.setQuantity(item.getQuantity());
                        itemDto.setPrice(item.getPrice());
                        return itemDto;
                    }).toList();

            // 3. Cria o DTO de Resposta Principal e preenche com os dados da Entidade
            OrdersResponseDto responseDto = new OrdersResponseDto();
            responseDto.setId(orders.getId());
            responseDto.setTotal(orders.getTotal());
            responseDto.setDate(orders.getCreated_at());
            responseDto.setOrdersItems(itemsResponseDto); // Injeta a lista de itens convertida

            // 4. Retorna o DTO de resposta correto para o seu HTTP GET
            return responseDto;
        } catch (Exception e) {
            throw new OrdersException("Erro ao buscar pedido pelo ID do usuário " + e.getMessage());
        }
    }
}
