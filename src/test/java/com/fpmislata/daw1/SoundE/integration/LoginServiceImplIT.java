package com.fpmislata.daw1.SoundE.integration;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.domain.service.LoginService;
import com.fpmislata.daw1.SoundE.domain.service.impl.LoginServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.LoginDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.LoginRepositoryImpl;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceImplIT extends JdbcTest {
    private final LoginService loginService = new LoginServiceImpl(
            new LoginRepositoryImpl(new LoginDaoJdbc())
    );

    @Nested
    class Authenticate {
        @Test
        void authenticate_shouldReturnUser_whenValidCredentials() {
            User result = loginService.authenticate("user1", "pass000");

            assertNotNull(result);
            assertEquals("user1", result.getUsername());
            assertEquals("user1@mail.com", result.getEmail());
        }

        @Test
        void authenticate_shouldReturnNull_whenInvalidCredentials() {
            User result = loginService.authenticate("user1", "passinvented");

            assertNull(result);
        }

        @Test
        void authenticate_shouldReturnNull_whenUserNotFound() {
            User result = loginService.authenticate("nonexistent", "anypass");

            assertNull(result);
        }
    }

    @Nested
    class UpdatePassword {
        @Test
        void updatePassword_shouldReturnTrue_whenSuccessful() {
            boolean result = loginService.updatePassword("user1", "newpass");
            User user1 = loginService.findByUsername("user1");
            assertTrue(result);

            User user = loginService.authenticate("user1", "newpass");
            assertNotNull(user);
        }

        @Test
        void updatePassword_shouldReturnFalse_whenFailed() {
            boolean result = loginService.updatePassword("nonexistent", "newpass");

            assertFalse(result);
        }
    }

    @Nested
    class Exists {
        @Test
        void exists_shouldReturnTrue_whenUserExists() {
            boolean result = loginService.exists("user1");

            assertTrue(result);
        }

        @Test
        void exists_shouldReturnFalse_whenUserDoesNotExist() {
            boolean result = loginService.exists("nonexistent");

            assertFalse(result);
        }
    }

    @Nested
    class FindByUsername {
        @Test
        void findByUsername_shouldReturnUser_whenExists() {
            User result = loginService.findByUsername("user1");

            assertNotNull(result);
            assertEquals("user1", result.getUsername());
            assertEquals("user1@mail.com", result.getEmail());
        }

        @Test
        void findByUsername_shouldReturnNull_whenDoesNotExist() {
            User result = loginService.findByUsername("nonexistent");

            assertNull(result);
        }
    }
}