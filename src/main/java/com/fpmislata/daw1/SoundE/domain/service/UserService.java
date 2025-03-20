package com.fpmislata.daw1.SoundE.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.User;

import java.time.LocalDate;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    void create(String username, String email, LocalDate birthDate, String photo, String password);
    void login(String username, String password);
}
