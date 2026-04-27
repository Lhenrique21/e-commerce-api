package com.example.e_commerce_api.mapper;

import com.example.e_commerce_api.dto.UserCreateDto;
import com.example.e_commerce_api.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User mapUserToEntityCreate(UserCreateDto userCreateDto){
        User user = new User();
        user.setName(userCreateDto.getName());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());

        return user;
    }
}
