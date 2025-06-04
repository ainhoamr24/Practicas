package com.fpmislata.daw1.SoundE.unit.domain.entity;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @ParameterizedTest(name = "(id={0}, username={1}, password={2}, email={3}, birthdate={4})")
    @DisplayName("User::constructor")
    @CsvSource({
        "1, user1, pass123, usuario1@gmail.com, 2000-01-15",
        "2, user2, pass456, usario2@gmail.com, 1995-06-20"
    })

    void userConstructorTest(Long id, String username, String password, String email, String birthdatStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(birthdatStr, formatter);

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setBirthdate(birthdate);

        assertAll(
                () -> assertEquals(user.getId(), id),
                () -> assertEquals(user.getUsername(), username),
                () -> assertEquals(user.getPassword(), password),
                () -> assertEquals(user.getEmail(), email),
                () -> assertEquals(user.getBirthdate(), birthdate)
        );
    }
}