package com.fpmislata.daw1.SoundE.persistance.repository;

import com.fpmislata.daw1.SoundE.domain.entity.User;

import java.time.LocalDate;

public interface UserRepository {
    User findByUserName(String username);
    User findByEmail(String email);
    void create(String username, String email, LocalDate birthDate, String photo, String password);
}
