package com.fpmislata.daw1.SoundE.common.container;

import com.fpmislata.daw1.SoundE.domain.service.LoginService;
import com.fpmislata.daw1.SoundE.domain.service.impl.LoginServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.LoginDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.LoginDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.LoginRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.LoginRepositoryImpl;

public class LoginIoc {
    private static LoginService loginService;
    private static LoginRepository loginRepository;
    private static LoginDao loginDao;

    public static LoginService createService() {
        if (loginService == null) {
            loginRepository = createRepository();
            loginService = new LoginServiceImpl(loginRepository);
        }
        return loginService;
    }

    public static LoginRepository createRepository() {
        if (loginRepository == null) {
            loginDao = createDao();
            loginRepository = new LoginRepositoryImpl(loginDao);
        }
        return loginRepository;
    }

    public static LoginDao createDao() {
        if (loginDao == null) {
            loginDao = new LoginDaoJdbc();
        }
        return loginDao;
    }
}

