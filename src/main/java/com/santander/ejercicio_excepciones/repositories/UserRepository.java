package com.santander.ejercicio_excepciones.repositories;

import com.santander.ejercicio_excepciones.entities.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserRepository {

    // this repository could have some connections to differents databases

    public boolean existsByEmail(String email) {
        // checks if the email exists in the db
        return false;
    }

    public UserEntity saveUser(UserEntity user) {
        // saves user in a db
        log.info("User saved in the DB");
        return user;
    }

}
