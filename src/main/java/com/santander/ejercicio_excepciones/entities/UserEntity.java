package com.santander.ejercicio_excepciones.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Entity
//@Table(name = "users")
public class UserEntity {

    private String email;
    private String password;

}
