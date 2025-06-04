package com.fpmislata.daw1.SoundE.unit.persistance.dao.jdbc;

import com.fpmislata.daw1.SoundE.data.LoginData;
import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.persistance.dao.LoginDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.LoginDaoJdbc;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class LoginDaoJdbcTest extends JdbcTest {
    private final LoginDao loginDao = new LoginDaoJdbc();

    public final List<User> expectedUserList = LoginData.USER_LIST;

    @Test
    void authenticate_shouldReturnUser_whenValidCredentials() {
        User result = loginDao.authenticate("user1", "pass000");
        assertEquals(expectedUserList.get(0), result);
        }

    @Test
    void authenticate_shouldReturnNull_whenInvalidUsername() {
        User result = loginDao.authenticate("userInvalid", "pass000");
        assertNull(result);
    }

    @Test
    void authenticate_shouldReturnNull_whenInvalidPassword() {
        User result = loginDao.authenticate("user1", "wrongpass");
        assertNull(result);
    }

}