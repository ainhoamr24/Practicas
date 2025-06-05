package com.fpmislata.daw1.SoundE.persistance.repository.impl;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.persistance.dao.LoginDao;
import com.fpmislata.daw1.SoundE.persistance.repository.LoginRepository;

public class LoginRepositoryImpl implements LoginRepository {

    private final LoginDao loginDao;

    public LoginRepositoryImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }


    public boolean updatePassword(String username, String newPassword) {
        return loginDao.updatePassword(username, newPassword);
    }

    public boolean exists(String username) {
        return loginDao.findByUsername(username) != null;
    }

    public User findByUsername(String username) {
        return loginDao.findByUsername(username);
    }
}

