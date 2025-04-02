package com.fpmislata.daw1.SoundE.common.container;

import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistSongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.PlaylistSongDaoJdbc;

public class PlaylistSongIoc {
    private static PlaylistSongDao playlistSongDao;

    public static PlaylistSongDao createDao() {
        if(playlistSongDao == null)
            playlistSongDao = new PlaylistSongDaoJdbc();

        return playlistSongDao;
    }
}
