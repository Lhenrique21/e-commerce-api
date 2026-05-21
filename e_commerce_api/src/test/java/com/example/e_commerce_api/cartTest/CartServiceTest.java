package com.example.e_commerce_api.cartTest;

import com.example.e_commerce_api.dto.CartItemsCreateDto;
import com.example.e_commerce_api.entity.Cart;
import com.example.e_commerce_api.entity.CartItems;
import com.example.e_commerce_api.entity.Products;
import com.example.e_commerce_api.entity.User;
import com.example.e_commerce_api.repository.CartItemsRepository;
import com.example.e_commerce_api.repository.CartRepository;
import com.example.e_commerce_api.repository.ProductsRepository;
import com.example.e_commerce_api.repository.UserRepository;
import com.example.e_commerce_api.service.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    UserRepository userRepository;
    @Mock
    ProductsRepository productsRepository;
    @Mock
    CartRepository cartRepository;
    @Mock
    CartItemsRepository cartItemsRepository;
    @InjectMocks
    CartService cartService;

    @Test
    public void mustAddProductToCart(){
        Long idUser=1L;
        Long idProduct=2L;
        Float quantity=1F;

        User user = new User();
        Cart cart = new Cart();

        cart.setCartItems(new ArrayList<>());

        user.setCart(cart);

        Products products = new Products();
        products.setId(idProduct);

        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Mockito.when(productsRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(products));
        Mockito.when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(cart);

        cartService.addProductToCart(idUser, idProduct, quantity);

        Mockito.verify(userRepository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(productsRepository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(cartRepository, Mockito.times(1)).save(cart);
    }

    @Test
    public void mustRemoveProductFromCart(){
        Long idUser=1L;
        Long idProduct=10L;
        Float quantity=1F;

        User user = new User();
        Cart cart = new Cart();

        Products products = new Products();
        products.setId(idProduct);

        CartItems  cartItems = new CartItems();
        cartItems.setCart(cart);
        cartItems.setProducts(products);

        List<CartItems> cartItems1 = new ArrayList<>();
        cartItems1.add(cartItems);

        cart.setCartItems(cartItems1);
        user.setCart(cart);

        Mockito.when(userRepository.findById(idUser)).thenReturn(Optional.of(user));


        cartService.removeProductsFromCart(idUser,idProduct,quantity );

        Mockito.verify(cartRepository, Mockito.times(1)).save(Mockito.any(Cart.class));
        Assertions.assertEquals(0, cart.getCartItems().size());

    }

    @Test
    public void mustCleanCart(){
        Long idUser = 1L;
        User user = new User();
        Cart cart = new Cart();
        user.setCart(cart);

        Mockito.when(userRepository.findById(idUser)).thenReturn(Optional.of(user));

        cartService.cleanCart(idUser);

        Mockito.verify(cartItemsRepository, Mockito.times(1)).deleteByCart(cart);
    }
}
