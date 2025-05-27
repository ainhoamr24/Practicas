package com.fpmislata.daw1.SoundE.persistance.repository;

import com.fpmislata.daw1.SoundE.domain.entity.User;

public interface LoginRepository {
    User authenticate(String username, String password);
    User findByUsername(String username);
    boolean updatePassword(String username, String newPassword);
    boolean exists(String username);
}
