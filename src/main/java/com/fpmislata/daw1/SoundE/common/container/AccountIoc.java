package com.fpmislata.daw1.SoundE.common.container;

import com.fpmislata.daw1.SoundE.domain.service.AccountService;
import com.fpmislata.daw1.SoundE.domain.service.impl.AccountServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.AccountDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.AccountDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.AccountRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.AccountRepositoryImpl;

public class AccountIoc {

    private static AccountService accountService;
    private static AccountRepository accountRepository;
    private static AccountDao accountDao;

    public static AccountService createService() {
        if (accountService == null) {
            accountRepository = createRepository();
            accountService = new AccountServiceImpl(accountRepository);
        }
        return accountService;
    }

    public static AccountRepository createRepository() {
        if (accountRepository == null) {
            accountDao = createDao();
            accountRepository = new AccountRepositoryImpl(accountDao);
        }
        return accountRepository;
    }

    public static AccountDao createDao() {
        if (accountDao == null) {
            accountDao = new AccountDaoJdbc();
        }
        return accountDao;
    }
}
