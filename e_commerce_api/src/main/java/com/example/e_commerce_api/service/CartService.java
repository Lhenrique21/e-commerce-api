package com.example.e_commerce_api.service;

import com.example.e_commerce_api.entity.Cart;
import com.example.e_commerce_api.entity.CartItems;
import com.example.e_commerce_api.entity.Products;
import com.example.e_commerce_api.entity.User;
import com.example.e_commerce_api.exception.CartException;
import com.example.e_commerce_api.repository.CartRepository;
import com.example.e_commerce_api.repository.ProductsRepository;
import com.example.e_commerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductsRepository productsRepository;

    public void addProductToCart(Long idUser, Long idProduct){
        try{

            User user = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            Cart cart = user.getCart();

            Products products = productsRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            List<CartItems> cartItems = cart.getCartItems();

            boolean alReadyExistsInCart = cartItems.stream().anyMatch(item -> item.getProducts().equals(products));
            if(!alReadyExistsInCart){
                CartItems newItem = new CartItems();
                newItem.setProducts(products);
                newItem.setCart(cart);

                cartItems.add(newItem);

                cartRepository.save(cart);
            }
        } catch (Exception e) {
            throw  new CartException("Erro ao adicionar produto ao carrinho " + e.getMessage());
        }
    }

    public void removeProductsFromCart(Long idUser, Long idProduct){
        try{
            User user = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            Cart cart = user.getCart();
            List<CartItems> cartItems = cart.getCartItems();

            boolean remove = cartItems.removeIf(item -> item.getProducts().getId().equals(idProduct));

            if (remove){
                cartRepository.save(cart);
            }
        } catch (Exception e){
            throw new CartException("Erro ao remover produto ao carrinho " + e.getMessage());
        }
    }

    public void cleanCart(){
        try{
            cartRepository.deleteAll();
        } catch (Exception e) {
            throw new CartException("Erro ao limpar carrinho " + e.getMessage());
        }
    }
}
