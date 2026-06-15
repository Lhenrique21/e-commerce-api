package com.example.e_commerce_api.service;

import com.example.e_commerce_api.entity.Cart;
import com.example.e_commerce_api.entity.CartItems;
import com.example.e_commerce_api.entity.Products;
import com.example.e_commerce_api.entity.User;
import com.example.e_commerce_api.exception.CartException;
import com.example.e_commerce_api.repository.CartItemsRepository;
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

    @Autowired
    CartItemsRepository cartItemsRepository;

    public void addProductToCart(Long idUser, Long idProduct, Float quantity) {
        try {

            User user = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            Cart cart = user.getCart();

            Products products = productsRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            List<CartItems> cartItems = cart.getCartItems();

            boolean alreadyExistsInCart = cartItems.stream().anyMatch(item -> java.util.Objects.equals(item.getProducts(), products));
            if (!alreadyExistsInCart) {
                CartItems newItem = new CartItems();
                newItem.setProducts(products);
                newItem.setCart(cart);
                newItem.setQuantity(quantity);
                cartItems.add(newItem);

                cartItemsRepository.save(newItem);
                cartRepository.save(cart);
            }
        } catch (Exception e) {

            throw new CartException("Erro ao adicionar produto ao carrinho " + e.getMessage());
        }
    }

    public void removeProductsFromCart(Long idUser, Long idProduct, Float quantity) {
        try {
            User user = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            Cart cart = user.getCart();
            List<CartItems> cartItems = cart.getCartItems();

            CartItems itemEncontrado = cartItems.stream()
                    .filter(item -> item.getProducts() != null && item.getProducts().getId().equals(idProduct))
                    .findFirst()
                    .orElse(null);

            if (itemEncontrado != null) {
                float novaQuantidade = itemEncontrado.getQuantity() - quantity;

                if (novaQuantidade <= 0) {
                    cartItems.remove(itemEncontrado);
                    cartItemsRepository.delete(itemEncontrado);
                } else {
                    itemEncontrado.setQuantity(novaQuantidade);
                    cartItemsRepository.save(itemEncontrado);
                }
            }
        } catch (Exception e) {
            throw new CartException("Erro ao remover produto ao carrinho " + e.getMessage());
        }
    }

    public void cleanCart(Long idUser) {
        try {
            User user = userRepository.findById(idUser).orElseThrow();
            Cart cart = user.getCart();

            if (cart != null && cart.getCartItems() != null) {
                cart.getCartItems().clear();
                cartRepository.save(cart);
            }
        } catch (Exception e) {
            throw new CartException("Erro ao limpar carrinho " + e.getMessage());
        }
    }
}
