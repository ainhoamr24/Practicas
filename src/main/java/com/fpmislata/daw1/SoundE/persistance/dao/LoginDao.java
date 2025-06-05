package com.fpmislata.daw1.SoundE.persistance.dao;

import com.fpmislata.daw1.SoundE.domain.entity.User;

public interface LoginDao {
    User findByUsername(String username);
    boolean updatePassword(String username, String newPassword);
    boolean exists(String username);
}
