package com.fpmislata.daw1.SoundE.unit.persistance.repostory;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.persistance.dao.LoginDao;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.LoginRepositoryImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginRepositoryImplTest {

    private final User USER = new User(1L, "user1", "pass000", "user1@mail.com", LocalDate.parse("2000-01-05"));

    @Mock
    private LoginDao loginDao;

    @InjectMocks
    private LoginRepositoryImpl loginRepository;

    @Nested
    class UpdatePassword {
        @Test
        void updatePassword_withValidData_shouldReturnTrue() {
            when(loginDao.updatePassword("user1", "newpass")).thenReturn(true);

            boolean result = loginRepository.updatePassword("user1", "newpass");

            assertTrue(result);
            verify(loginDao).updatePassword("user1", "newpass");
        }

        @Test
        void updatePassword_withInvalidData_shouldReturnFalse() {
            when(loginDao.updatePassword("invalid", "newpass")).thenReturn(false);

            boolean result = loginRepository.updatePassword("invalid", "newpass");

            assertFalse(result);
            verify(loginDao).updatePassword("invalid", "newpass");
        }
    }

    @Nested
    class Exists {
        @Test
        void exists_withExistingUsername_shouldReturnTrue() {
            when(loginDao.findByUsername("user1")).thenReturn(USER);

            boolean result = loginRepository.exists("user1");

            assertTrue(result);
            verify(loginDao).findByUsername("user1");
        }

        @Test
        void exists_withNonExistingUsername_shouldReturnFalse() {
            when(loginDao.findByUsername("invalid")).thenReturn(null);

            boolean result = loginRepository.exists("invalid");

            assertFalse(result);
            verify(loginDao).findByUsername("invalid");
        }
    }

    @Nested
    class FindByUsername {
        @Test
        void findByUsername_withExistingUsername_shouldReturnUser() {
            when(loginDao.findByUsername("user1")).thenReturn(USER);

            User result = loginRepository.findByUsername("user1");

            assertEquals(USER, result);
            verify(loginDao).findByUsername("user1");
        }

        @Test
        void findByUsername_withNonExistingUsername_shouldReturnNull() {
            when(loginDao.findByUsername("invalid")).thenReturn(null);

            User result = loginRepository.findByUsername("invalid");

            assertNull(result);
            verify(loginDao).findByUsername("invalid");
        }
    }
}