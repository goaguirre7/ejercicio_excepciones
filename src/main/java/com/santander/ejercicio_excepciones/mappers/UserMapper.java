package com.santander.ejercicio_excepciones.mappers;

import com.santander.ejercicio_excepciones.dtos.UserDto;
import com.santander.ejercicio_excepciones.entities.UserEntity;
import com.santander.ejercicio_excepciones.models.UserModel;

public class UserMapper {

    public static UserModel toUserModel(UserDto user) {
        return new UserModel(user.getEmail(), user.getPassword());
    }

    public static UserModel toUserModel(UserEntity user) {
        return new UserModel(user.getEmail(), user.getPassword());
    }

    public static UserDto toUserDto(UserModel user) {
        return new UserDto(user.getEmail(), user.getPassword());
    }

    public static UserEntity toUserEntity(UserModel user) {
        return new UserEntity(user.getEmail(), user.getPassword());
    }

}
