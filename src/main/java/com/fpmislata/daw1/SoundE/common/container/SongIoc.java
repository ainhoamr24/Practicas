package com.fpmislata.daw1.SoundE.common.container;

import com.fpmislata.daw1.SoundE.domain.service.SongService;
import com.fpmislata.daw1.SoundE.domain.service.impl.SongServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.SongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.SongDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.SongRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.SongRepositoryImpl;

public class SongIoc {
    private static SongService songService;
    private static SongRepository songRepository;
    private static SongDao songDao;

    public static SongService createService() {
        if(songService == null) {
            songRepository = createRepository();
            songService = new SongServiceImpl(songRepository);
        }

        return songService;
    }

    public static SongRepository createRepository() {
        if(songRepository == null) {
            songDao = createDao();
            songRepository = new SongRepositoryImpl(songDao);
        }

        return songRepository;
    }

    public static SongDao createDao() {
        if (songDao == null)
            songDao = new SongDaoJdbc();

        return songDao;
    }
}
