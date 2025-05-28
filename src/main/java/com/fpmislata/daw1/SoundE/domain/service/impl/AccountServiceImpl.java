package com.fpmislata.daw1.SoundE.domain.service.impl;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.domain.service.AccountService;
import com.fpmislata.daw1.SoundE.persistance.repository.AccountRepository;
import utils.Password;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public User create(User user) {
        String hashedPassword = Password.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        return accountRepository.create(user);
    }

    @Override
    public User findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}

