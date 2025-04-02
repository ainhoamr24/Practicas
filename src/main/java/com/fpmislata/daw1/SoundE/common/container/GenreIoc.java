package com.fpmislata.daw1.SoundE.common.container;

import com.fpmislata.daw1.SoundE.domain.service.GenreService;
import com.fpmislata.daw1.SoundE.domain.service.impl.GenreServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.GenreDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.GenreDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.GenreRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.GenreRepositoryImpl;


public class GenreIoc {
    private static GenreService genreService;
    private static GenreRepository genreRepository;
    private static GenreDao genreDao;

    public static GenreService createService() {
        if(genreService == null) {
            genreRepository = createRepository();
            genreService = new GenreServiceImpl(genreRepository);
        }

        return genreService;
    }

    public static GenreRepository createRepository() {
        if(genreRepository == null) {
            genreDao = createDao();
            genreRepository = new GenreRepositoryImpl(genreDao);
        }

        return genreRepository;
    }

    public static GenreDao createDao() {
        if(genreDao == null)
            genreDao = new GenreDaoJdbc();

        return genreDao;
    }
}

