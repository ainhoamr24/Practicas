package com.fpmislata.daw1.SoundE.domain.service.impl;
import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.domain.service.LoginService;
import com.fpmislata.daw1.SoundE.persistance.repository.LoginRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.PlaylistRepository;
import utils.Password;

public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public User authenticate(String username, String password) {

        User user = loginRepository.findByUsername(username);
        if (user != null && Password.matchPassword(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        User user = loginRepository.findByUsername(username);
        String hashedPassword = Password.hashPassword(newPassword);
        if ( user == null) {
            return false;
        }
        user.setPassword(hashedPassword);
        return loginRepository.updatePassword(username, hashedPassword);
    }

    @Override
    public boolean exists(String username) {
        return loginRepository.exists(username);
    }

    @Override
    public User findByUsername(String username) {
        return loginRepository.findByUsername(username);
    }


}

