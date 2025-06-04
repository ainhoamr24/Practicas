package com.fpmislata.daw1.SoundE.data;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.List;


public class LoginData {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final String HASH_PASS_000 = passwordEncoder.encode("pass000");
    private static final String HASH_PASS_111 = passwordEncoder.encode("pass111");
    private static final String HASH_PASS_222 = passwordEncoder.encode("pass222");
    private static final String HASH_PASS_333 = passwordEncoder.encode("pass333");
    public static final List<User> USER_LIST = List.of(
            new User(1L, "user1", HASH_PASS_000, "user1@mail.com", LocalDate.parse("2000-01-05")),
            new User(2L, "user2", HASH_PASS_111, "user2@mail.com", LocalDate.parse("2001-02-10")),
            new User(3L, "user3", HASH_PASS_222, "user3@mail.com", LocalDate.parse("2002-03-15")),
            new User(4L, "user4", HASH_PASS_333, "user4@mail.com", LocalDate.parse("2003-04-20"))
    );
}
