package com.fpmislata.daw1.SoundE.data;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import java.time.LocalDate;
import java.util.List;

public class LoginData {
    private static final String HASH_PASS = "$2a$10$xN4rBmOJ3PAVTL5pDA/STOOI8cj1MlBX2Dnbg4RYduRYvz/ivyeJG";

    public static final List<User> USER_LIST = List.of(
            new User(1L, "user1", HASH_PASS, "user1@mail.com", LocalDate.parse("2000-01-05")),
            new User(2L, "user2", HASH_PASS, "user2@mail.com", LocalDate.parse("2001-02-10")),
            new User(3L, "user3", HASH_PASS, "user3@mail.com", LocalDate.parse("2002-03-15")),
            new User(4L, "user4", HASH_PASS, "user4@mail.com", LocalDate.parse("2003-04-20"))
    );
}