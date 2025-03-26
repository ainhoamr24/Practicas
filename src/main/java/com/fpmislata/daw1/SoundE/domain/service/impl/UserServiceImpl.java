package com.fpmislata.daw1.SoundE.domain.service.impl;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.domain.service.UserService;
import com.fpmislata.daw1.SoundE.persistance.repository.UserRepository;

import java.time.LocalDate;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User findByEmail(String email) { return userRepository.findByEmail(email); }

    @Override
    public void create(String username, String email, LocalDate birthDate, String photo, String password) {
        if (findByUserName(username) != null) {
            throw new RuntimeException("Ya existe un usuario con este nombre");
        } else if (findByEmail(email) != null) {
            throw new RuntimeException("Ya existe un usuario con este correo electronico");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setBirthdate(birthDate);
        user.setImgPath("/img/icons/icon.svg");
        userRepository.create(username, email, birthDate, photo, password);
    }
}
