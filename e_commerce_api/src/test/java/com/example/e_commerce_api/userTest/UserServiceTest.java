package com.example.e_commerce_api.userTest;

import com.example.e_commerce_api.dto.UserCreateDto;
import com.example.e_commerce_api.entity.User;
import com.example.e_commerce_api.repository.UserRepository;
import com.example.e_commerce_api.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void mustCreateUser(){
        UserCreateDto userCreateDto = UserTest.userCreateDto();

        Mockito.when(userRepository.save(Mockito.any())).thenReturn(new User());

        userService.createUser(userCreateDto);

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void mustDeleteUser(){
        Mockito.doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void mustUpdateUser(){
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(UserTest.user()));
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(new User());

        userService.updateUser(UserTest.userUpdateDto());

        Mockito.verify(userRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void mustFindById(){
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(UserTest.user()));

        userService.findById(1L);

        Mockito.verify(userRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void mustFindByEmail(){
        Mockito.when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(UserTest.user()));

        userService.findByEmail(UserTest.user().getEmail());

        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(Mockito.any());
    }

    @Test
    public void mustFindAll(){
        Mockito.when(userRepository.findAll()).thenReturn(List.of(UserTest.user()));

        List<User> users = userService.findAll();

        Assertions.assertEquals("Test name", users.get(0).getName());
        Assertions.assertEquals("Test email", users.get(0).getEmail());
        Assertions.assertEquals("Test password", users.get(0).getPassword());

        Assertions.assertNotNull(users.get(0));
    }

}
