package com.example.e_commerce_api.productsTest;

import com.example.e_commerce_api.dto.ProductsCreateDto;
import com.example.e_commerce_api.entity.Products;
import com.example.e_commerce_api.repository.ProductsRepository;
import com.example.e_commerce_api.service.ProductsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductsServiceTest {

    @Mock
    ProductsRepository productsRepository;

    @InjectMocks
    ProductsService productsService;

    @Test
    public void mostCreateProducts(){
        ProductsCreateDto  productsCreateDto = ProductsTest.productsCreateDto();

        Mockito.when(productsRepository.save(Mockito.any())).thenReturn(new Products());

        productsService.createProducts(productsCreateDto);

        Mockito.verify(productsRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void mustDeleteProducts(){
        Mockito.doNothing().when(productsRepository).deleteById(1L);

        productsService.deleteById(1L);

        Mockito.verify(productsRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void mustUpdateProducts(){
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.of(ProductsTest.products()));
        Mockito.when(productsRepository.save(Mockito.any())).thenReturn(new Products());

        productsService.updateProducts(ProductsTest.productsUpdateDto());

        Mockito.verify(productsRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(productsRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void mustFindById(){
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.of(ProductsTest.products()));

        productsService.findById(1L);

        Mockito.verify(productsRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void mustFindAll(){
        Mockito.when(productsRepository.findAll()).thenReturn(List.of(ProductsTest.products()));

        List<Products> productsList = productsService.findAll();

        Mockito.verify(productsRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void mustFindByName(){
        Mockito.when(productsRepository.findByName(Mockito.any())).thenReturn(Optional.of(ProductsTest.products()));

        productsService.findByName("Test name");

        Mockito.verify(productsRepository, Mockito.times(1)).findByName(Mockito.any());
    }
}
