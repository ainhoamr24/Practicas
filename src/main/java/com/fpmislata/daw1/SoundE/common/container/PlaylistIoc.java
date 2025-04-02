package com.fpmislata.daw1.SoundE.common.container;

import com.fpmislata.daw1.SoundE.domain.service.PlaylistService;
import com.fpmislata.daw1.SoundE.domain.service.impl.PlaylistServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistDao;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistSongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.PlaylistDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.PlaylistRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.PlaylistRepositoryImpl;

public class PlaylistIoc {
    private static PlaylistService playlistService;
    private static PlaylistRepository playlistRepository;
    private static PlaylistDao playlistDao;

    public static PlaylistService createService() {
        if(playlistService == null) {
            playlistRepository = createRepository();
            playlistService = new PlaylistServiceImpl(playlistRepository);
        }

        return playlistService;
    }

    public static PlaylistRepository createRepository() {
        if(playlistRepository == null) {
            playlistDao = createDao();
            PlaylistSongDao playlistSongDao = PlaylistSongIoc.createDao();
            playlistRepository = new PlaylistRepositoryImpl(playlistDao,playlistSongDao);
        }

        return playlistRepository;
    }

    public static PlaylistDao createDao() {
        if(playlistDao == null)
            playlistDao = new PlaylistDaoJdbc();

        return playlistDao;
    }
}
