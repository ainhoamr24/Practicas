package com.fpmislata.daw1.SoundE.unit.domain.service;

import com.fpmislata.daw1.SoundE.data.LoginData;
import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.domain.service.impl.LoginServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.repository.LoginRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.Password;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class LoginServiceImplTest {
    public final List<User> USER_LIST = LoginData.USER_LIST;

    @Mock
    private LoginRepository loginRepository;

    @InjectMocks
    private LoginServiceImpl loginService;

    @Nested
    class Authenticate {
        @Test
        void authenticate_shouldReturnUser_whenValidCredentials() {
            User testUser = USER_LIST.get(0);
            when(loginRepository.findByUsername("user1")).thenReturn(testUser);

            User result = loginService.authenticate("user1", "pass000");

            assertNotNull(result);
            assertEquals(testUser, result);
        }

        @Test
        void authenticate_shouldReturnNull_whenInvalidCredentials() {
            when(loginRepository.findByUsername("user1")).thenReturn(USER_LIST.get(0));

            User result = loginService.authenticate("user1", "passinvented");

            assertNull(result);
        }

        @Test
        void authenticate_shouldReturnNull_whenUserNotFound() {
            when(loginRepository.findByUsername("nonexistent")).thenReturn(null);

            User result = loginService.authenticate("nonexistent", "anypass");

            assertNull(result);
        }
    }

    @Nested
    class UpdatePassword {
        @Test
        void updatePassword_shouldReturnTrue_whenSuccessful() {
            when(loginRepository.findByUsername("user1")).thenReturn(USER_LIST.get(0));
            when(loginRepository.updatePassword(eq("user1"), anyString())).thenReturn(true);

            boolean result = loginService.updatePassword("user1", "newpass");

            assertTrue(result);
        }

        @Test
        void updatePassword_shouldReturnFalse_whenFailed() {
            when(loginRepository.findByUsername("nonexistent")).thenReturn(null);

            boolean result = loginService.updatePassword("nonexistent", "newpass");

            assertFalse(result);
        }
    }

    @Nested
    class Exists {
        @Test
        void exists_shouldReturnTrue_whenUserExists() {
            when(loginRepository.exists("user1")).thenReturn(true);

            boolean result = loginService.exists("user1");

            assertTrue(result);
        }

        @Test
        void exists_shouldReturnFalse_whenUserDoesNotExist() {
            when(loginRepository.exists("nonexistent")).thenReturn(false);

            boolean result = loginService.exists("nonexistent");

            assertFalse(result);
        }
    }

    @Nested
    class FindByUsername {
        @Test
        void findByUsername_shouldReturnUser_whenExists() {
            when(loginRepository.findByUsername("user1")).thenReturn(USER_LIST.get(0));

            User result = loginService.findByUsername("user1");

            assertNotNull(result);
            assertEquals(USER_LIST.get(0), result);
        }

        @Test
        void findByUsername_shouldReturnNull_whenDoesNotExist() {
            when(loginRepository.findByUsername("nonexistent")).thenReturn(null);

            User result = loginService.findByUsername("nonexistent");

            assertNull(result);
        }
    }
}