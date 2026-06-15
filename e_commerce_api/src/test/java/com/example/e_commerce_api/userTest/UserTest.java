package com.example.e_commerce_api.userTest;

import com.example.e_commerce_api.dto.UserCreateDto;
import com.example.e_commerce_api.dto.UserUpdateDto;
import com.example.e_commerce_api.entity.User;

public class UserTest {

    public static UserCreateDto userCreateDto(){
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setName("Test name");
        userCreateDto.setEmail("Test email");
        userCreateDto.setPassword("Test password");
        return userCreateDto;
    }

    public static User user(){
        User user = new User();
        user.setName("Test name");
        user.setEmail("Test email");
        user.setPassword("Test password");
        return user;
    }

    public static UserUpdateDto userUpdateDto(){
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setId(1L);
        userUpdateDto.setName("Test name");
        userUpdateDto.setEmail("Test email");
        userUpdateDto.setPassword("Test password");
        return userUpdateDto;
    }
}
