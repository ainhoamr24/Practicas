package com.fpmislata.daw1.SoundE.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.User;

import java.util.List;

public interface AccountService {
    User create(User user);
    User findById(Long id);
    List<User> findAll();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User findByUsername(String username);
}

