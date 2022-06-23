package com.santander.ejercicio_excepciones.controllers;

import com.santander.ejercicio_excepciones.dtos.UserDto;
import com.santander.ejercicio_excepciones.mappers.UserMapper;
import com.santander.ejercicio_excepciones.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody @Valid UserDto user) {
        return UserMapper.toUserDto(userService.createUser(UserMapper.toUserModel(user)));
    }

}
