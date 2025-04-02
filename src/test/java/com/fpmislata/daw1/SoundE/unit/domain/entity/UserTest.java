package com.fpmislata.daw1.SoundE.unit.domain.entity;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
class UserTest {
    @ParameterizedTest(name = "User vacio, setters(id = {0}, name = {1}, email = {2},  birthDate = {3}, imgPath = {4})")
    @DisplayName("User::Constructor")
    @CsvSource({
            "1, Javier, javier.ejemplo@gmail.com, 2024-12-02, /img/users/1/javier, /img/users/1/javier",
            "2, Lusmi, Luismi.ejemplo@gmail.com, 1023-12-02, '', /img/icons/icon.svg"
    })
    void userConstructorTest(Long id, String username, String email, String birthDateStr, String imgPath, String expectedImagePath) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setBirthdate(birthDate);
        user.setImgPath(imgPath);

        assertAll(
                () -> assertEquals(user.getId(), id),
                () -> assertEquals(user.getUsername(), username),
                () -> assertEquals(user.getEmail(), email),
                () -> assertEquals(user.getBirthdate(), birthDate),
                () -> assertEquals(user.getImgPath(), expectedImagePath)
        );
    }
}