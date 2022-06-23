package com.santander.ejercicio_excepciones.services;

import com.santander.ejercicio_excepciones.exceptions.UserAlreadyRegisteredException;
import com.santander.ejercicio_excepciones.mappers.UserMapper;
import com.santander.ejercicio_excepciones.models.UserModel;
import com.santander.ejercicio_excepciones.repositories.UserRepository;
import com.santander.ejercicio_excepciones.utils.EmailUtil;
import com.santander.ejercicio_excepciones.utils.FileUtil;
import com.santander.ejercicio_excepciones.utils.QueueUtil;
import com.santander.ejercicio_excepciones.utils.SlackUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) {

            EmailUtil.sendEmail(
                    "no-response@exceptionexample.com",
                    "User already exists",
                    "..."
            );

            FileUtil.writeFile("...");

            throw new UserAlreadyRegisteredException(String.format("El email %s ya se encuentra registrado", user.getEmail()));
        }

        UserModel userSaved = UserMapper.toUserModel(userRepository.saveUser(UserMapper.toUserEntity(user)));

        SlackUtil.sendMessage("soporte", "...");

        QueueUtil.queue("...");

        FileUtil.writeFile("...");

        // hides the password
        userSaved.setPassword(null);
        return userSaved;
    }

}
