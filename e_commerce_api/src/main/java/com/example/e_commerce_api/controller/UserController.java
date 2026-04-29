package com.example.e_commerce_api.controller;

import com.example.e_commerce_api.dto.UserCreateDto;
import com.example.e_commerce_api.dto.UserUpdateDto;
import com.example.e_commerce_api.entity.User;
import com.example.e_commerce_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody UserCreateDto userCreateDto){
        userService.createUser(userCreateDto);
    }

    @GetMapping("/findById")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/findByEmail")
    public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserUpdateDto userUpdateDto){
        userService.updateUser(userUpdateDto);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
