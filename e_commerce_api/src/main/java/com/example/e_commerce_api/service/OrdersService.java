package com.example.e_commerce_api.service;

import com.example.e_commerce_api.dto.OrdersCreateDto;
import com.example.e_commerce_api.entity.Orders;
import com.example.e_commerce_api.exception.OrdersException;
import com.example.e_commerce_api.mapper.OrdersMapper;
import com.example.e_commerce_api.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public void createOrder(OrdersCreateDto ordersCreateDto) {
            try{
                Orders orders = OrdersMapper.mapOrdersToEntityCreate(ordersCreateDto);
                ordersRepository.save(orders);
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

    public List<Orders> findAll(){
        try {
            return ordersRepository.findAll();
        } catch (Exception e) {
            throw new OrdersException("Erro ao buscar pedidos " + e.getMessage());
        }
    }

    public Orders findByUserId(Long idUser){
        try{
            return  ordersRepository.findByUserId(idUser).get();
        } catch (Exception e) {
            throw new OrdersException("Erro ao buscar pedido pelo ID do usuário " + e.getMessage());
        }
    }
}
