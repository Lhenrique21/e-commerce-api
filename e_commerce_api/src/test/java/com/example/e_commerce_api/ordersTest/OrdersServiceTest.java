package com.example.e_commerce_api.ordersTest;

import com.example.e_commerce_api.dto.OrdersCreateDto;
import com.example.e_commerce_api.entity.Orders;
import com.example.e_commerce_api.repository.OrdersRepository;
import com.example.e_commerce_api.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OrdersServiceTest {

    @Mock
    OrdersRepository ordersRepository;

    @InjectMocks
    OrdersService ordersService;

    @Test
    public void mustCreateOrders(){
        OrdersCreateDto  ordersCreateDto = OrdersTest.ordersCreateDto();
        Long idUser = 1L;
        Mockito.when(ordersRepository.save(Mockito.any())).thenReturn(new Orders());

        ordersService.createOrder(idUser , ordersCreateDto);

        Mockito.verify(ordersRepository,Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void mustDeleteOrders(){
        Mockito.doNothing().when(ordersRepository).deleteById(1L);

        ordersService.deleteOrder(1L);

        Mockito.verify(ordersRepository,Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void mustFindById(){
        Mockito.when(ordersRepository.findById(1L)).thenReturn(Optional.of(OrdersTest.orders()));

        Orders orders = ordersService.findById(1L);

        Mockito.verify(ordersRepository,Mockito.times(1)).findById(1L);
    }

    @Test
    public void mustFindAll(){
        Mockito.when(ordersRepository.findAll()).thenReturn(List.of(OrdersTest.orders()));

        List<Orders> orders = ordersService.findAll();

        Mockito.verify(ordersRepository,Mockito.times(1)).findAll();
    }

    @Test
    public void mustFindByUserId(){
        Mockito.when(ordersRepository.findByUserId(1L)).thenReturn(Optional.of(OrdersTest.orders()));

        Orders orders = ordersService.findByUserId(1L);

        Mockito.verify(ordersRepository,Mockito.times(1)).findByUserId(1L);
    }
}
