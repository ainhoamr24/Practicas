package com.fpmislata.daw1.SoundE.persistance.repository.impl;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.persistance.dao.AccountDao;
import com.fpmislata.daw1.SoundE.persistance.repository.AccountRepository;

import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    private final AccountDao accountDao;

    public AccountRepositoryImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public User create(User user) {
        return accountDao.create(user);
    }

    @Override
    public User findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return accountDao.findAll();
    }

    @Override
    public boolean existsByUsername(String username) {
        return accountDao.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return accountDao.existsByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return accountDao.findByUsername(username);
    }
}

