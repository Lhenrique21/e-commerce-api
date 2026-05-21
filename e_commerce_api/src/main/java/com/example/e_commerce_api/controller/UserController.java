package com.example.e_commerce_api.controller;

import com.example.e_commerce_api.dto.UserCreateDto;
import com.example.e_commerce_api.dto.UserUpdateDto;
import com.example.e_commerce_api.entity.User;
import com.example.e_commerce_api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Usuário", description = "Endpoints para gerenciamento dos usuários")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Cria um usuário", description = "Recebe um DTO para criação do usuário")
    @PostMapping("/create")
    public void createUser(@RequestBody UserCreateDto userCreateDto) {
        userService.createUser(userCreateDto);
    }

    @Operation(summary = "Busca o usuário pelo ID", description = "Recebe um ID para busca do usuário")
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }


    @Operation(summary = "Busca o usuário pelo email", description = "Recebe um email para busca do usuário")
    @GetMapping("/findByEmail/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @Operation(summary = "Busca todos os usuários", description = "Retorna todos os usuários")
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }


    @Operation(summary = "Atualiza usuário", description = "Atualiza usuário de acordo com o ID")
    @PutMapping("/update")
    public void updateUser(@RequestBody UserUpdateDto userUpdateDto) {
        userService.updateUser(userUpdateDto);
    }


    @Operation(summary = "Deleta usuário", description = "Recebe um ID para deletar o usuário")
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
