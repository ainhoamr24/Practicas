package com.fpmislata.daw1.SoundE.domain.service;

import java.time.LocalDate;

public interface UserService {
    void createUser(String name, String email, LocalDate birthDate, String photo, String passwordConfirmation);
    void login(String email, String password);
}
