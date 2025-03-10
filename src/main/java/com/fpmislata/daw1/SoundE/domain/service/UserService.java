package com.fpmislata.daw1.SoundE.domain.service;

import java.time.LocalDate;

public interface UserService {
    void createUser(String name, String email, String password, LocalDate birthDate, String photo);
    void login(String email, String password);
}
