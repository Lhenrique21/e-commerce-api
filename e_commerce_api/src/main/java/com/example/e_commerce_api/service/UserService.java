package com.example.e_commerce_api.service;

import com.example.e_commerce_api.dto.UserCreateDto;
import com.example.e_commerce_api.dto.UserUpdateDto;
import com.example.e_commerce_api.entity.Cart;
import com.example.e_commerce_api.entity.User;
import com.example.e_commerce_api.exception.UserException;
import com.example.e_commerce_api.mapper.UserMapper;
import com.example.e_commerce_api.repository.CartRepository;
import com.example.e_commerce_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    public void createUser(UserCreateDto userCreateDto) {
        try {
            User userToSave = UserMapper.mapUserToEntityCreate(userCreateDto);
            Cart cart = new Cart();
            cart.setUser(userToSave);
            userToSave.setCart(cart);
            userRepository.save(userToSave);
        } catch (Exception e) {
            throw new UserException("Erro ao salvar usuário " + e.getMessage());
        }
    }

    public User findById(Long id) {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            throw new UserException("Erro ao buscar usuário pelo ID " + e.getMessage());
        }
    }

    public User findByEmail(String email) {
        try {
            User user = userRepository.findByEmail(email).get();
            return user;
        } catch (Exception e) {
            throw new UserException("Erro ao buscar usuário pelo email " + e.getMessage());
        }
    }

    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new UserException("Erro ao buscar usuários" + e.getMessage());
        }
    }

    public User updateUser(UserUpdateDto userUpdateDto) {
        try {
            Optional<User> optionalUser = userRepository.findById(userUpdateDto.getId());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                user.setName(userUpdateDto.getName());
                user.setEmail(userUpdateDto.getEmail());
                user.setPassword(userUpdateDto.getPassword());
                return userRepository.save(user);
            }
        } catch (Exception e) {
            throw new UserException("Erro ao atualizar estudante " + e.getMessage());
        }
        throw new UserException("Erro ao atualizar estudante ");
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserException("Erro ao deletar estudante " + e.getMessage());
        }
    }

}

