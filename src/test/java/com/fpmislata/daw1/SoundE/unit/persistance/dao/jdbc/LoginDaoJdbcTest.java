package com.fpmislata.daw1.SoundE.unit.persistance.dao.jdbc;

import com.fpmislata.daw1.SoundE.data.LoginData;
import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.persistance.dao.LoginDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.LoginDaoJdbc;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoginDaoJdbcTest extends JdbcTest {
    private final LoginDao loginDao = new LoginDaoJdbc();
    private final List<User> expectedUserList = LoginData.USER_LIST;

    @Nested
    class FindByUsername {
        @Test
        void findByUsername_shouldReturnUser() {
            User result = loginDao.findByUsername("user1");
            assertEquals(expectedUserList.get(0), result);
        }

        @Test
        void findByNonExistentUsername_shouldReturnNull() {
            User result = loginDao.findByUsername("nonexistent");
            assertNull(result);
        }
    }

    @Nested
    class UpdatePassword {
        @Test
        void updatePassword_withExistingUser_shouldReturnTrue() {
            String newHashedPassword = "$2a$10$newHashedPassword";
            boolean result = loginDao.updatePassword("user1", newHashedPassword);

            assertTrue(result);
            assertEquals(newHashedPassword, loginDao.findByUsername("user1").getPassword());
        }

        @Test
        void updatePassword_withNonExistingUser_shouldReturnFalse() {
            boolean result = loginDao.updatePassword("nonexistent", "$2a$10$newHashedPassword");
            assertFalse(result);
        }
    }

    @Nested
    class Exists {
        @Test
        void exists_withExistingUser_shouldReturnTrue() {
            boolean result = loginDao.exists("user1");
            assertTrue(result);
        }

        @Test
        void exists_withDifferentExistingUser_shouldReturnTrue() {
            boolean result = loginDao.exists("user2");
            assertTrue(result);
        }

        @Test
        void exists_withNonExistingUser_shouldReturnFalse() {
            boolean result = loginDao.exists("nonexistent");
            assertFalse(result);
        }
    }
}