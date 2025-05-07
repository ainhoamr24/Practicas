package com.fpmislata.daw1.SoundE.unit.persistance.dao.jdbc;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.PlaylistDaoJdbc;
import com.fpmislata.daw1.SoundE.data.PlaylistData;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistDaoJdbcTest extends JdbcTest {
    private final PlaylistDao playlistDao = new PlaylistDaoJdbc();

    public final List<Playlist> expectedPlaylistList = PlaylistData.PLAYLIST_LIST;

    @Nested
    class FindById {
        @Test
        void findById_shouldReturnPlaylist() {
            Playlist result = playlistDao.findById(1L);
            assertEquals(expectedPlaylistList.get(0), result);
        }

        @Test
        void findByDifferentId_shouldReturnDifferentPlaylist() {
            Playlist result = playlistDao.findById(2L);
            assertEquals(expectedPlaylistList.get(1), result);
        }

        @Test
        void findByNonExistentId_shouldReturnNull() {
            Playlist result = playlistDao.findById(5L);
            assertNull(result);
        }
    }

    @Nested
    class FindAll {
        @Test
        void findAll_shouldReturnAllPlaylists() {
            List<Playlist> result = playlistDao.findAll();
            assertEquals(expectedPlaylistList, result);
        }
    }

    @Nested
    class FindByName {
        @Test
        void findByName_shouldReturnMatchingSongs() {
            List<Playlist> result = playlistDao.findByName("Gorillaz");
            List<Playlist> expectedList = List.of(expectedPlaylistList.get(0));

            assertEquals(expectedList, result);
        }

        @Test
        void findByName_shouldReturnMultipleMatchingSongs() {
            List<Playlist> result = playlistDao.findByName("i");
            List<Playlist> expectedList = List.of(expectedPlaylistList.get(0), expectedPlaylistList.get(1), expectedPlaylistList.get(3));

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExisistentName_shouldReturnEmptyList() {
            List<Playlist> result = playlistDao.findByName("p");
            assertTrue(result.isEmpty());
        }
    }
}
