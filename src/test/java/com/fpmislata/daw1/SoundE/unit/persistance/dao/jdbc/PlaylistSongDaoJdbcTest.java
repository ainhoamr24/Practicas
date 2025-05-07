package com.fpmislata.daw1.SoundE.unit.persistance.dao.jdbc;

import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistSongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.PlaylistSongDaoJdbc;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;

public class PlaylistSongDaoJdbcTest extends JdbcTest {
    private final PlaylistSongDao playlistSongDao = new PlaylistSongDaoJdbc();
}
