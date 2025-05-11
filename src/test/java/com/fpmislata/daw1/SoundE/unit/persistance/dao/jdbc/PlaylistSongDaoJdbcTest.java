package com.fpmislata.daw1.SoundE.unit.persistance.dao.jdbc;

import com.fpmislata.daw1.SoundE.data.PlaylistData;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistSongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.PlaylistSongDaoJdbc;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistSongDaoJdbcTest extends JdbcTest {
    private final PlaylistSongDao playlistSongDao = new PlaylistSongDaoJdbc();

    public final List<Playlist> expectedPlaylistList = PlaylistData.PLAYLIST_LIST;

    @Nested
    class FindByGente {
        @Test
        void givenGenre_shouldReturnListOfPlaylistWithIt() {
            List<Playlist> expectedList = List.of(expectedPlaylistList.get(0));

            List<Playlist> result = playlistSongDao.findByGenre("Alternative Rock");

            assertEquals(expectedList, result);
        }

        @Test
        void givenGenre_shouldReturnListOfPlaylistsWithIt(){
            List<Playlist> expectedList = List.of(expectedPlaylistList.get(1), expectedPlaylistList.get(2));

            List<Playlist> result = playlistSongDao.findByGenre("Indie Rock");

            assertEquals(expectedList, result);
        }

        @Test
        void givenNonExistentGenre_shouldReturnEmptyList() {
            List<Playlist> result = playlistSongDao.findByGenre("Inventado");

            assertTrue(result.isEmpty());
        }
    }
}
