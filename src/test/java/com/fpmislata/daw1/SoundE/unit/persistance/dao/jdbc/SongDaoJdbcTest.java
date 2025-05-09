package com.fpmislata.daw1.SoundE.unit.persistance.dao.jdbc;

import com.fpmislata.daw1.SoundE.data.PlaylistData;
import com.fpmislata.daw1.SoundE.data.SongData;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.persistance.dao.SongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.SongDaoJdbc;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class SongDaoJdbcTest extends JdbcTest {
    private final SongDao songDao = new SongDaoJdbc();

    public final List<Song> expectedSongList = SongData.SONG_LIST;

    @Nested
    class FindById {
        @Test
        void findById_shouldReturnSong() {
            Song result = songDao.findById(1L);
            assertEquals(expectedSongList.get(0), result);
        }

        @Test
        void findByDifferentId_shouldReturnDifferentSong() {
            Song result = songDao.findById(2L);
            assertEquals(expectedSongList.get(1), result);
        }

        @Test
        void findByNonExistentId_shouldReturnNull() {
            Song result = songDao.findById(20L);
            assertNull(result);
        }
    }

    @Nested
    class FindAll {
        @Test
        void findAll_shouldReturnAllSongs() {
            List<Song> result = songDao.findAll();
            assertEquals(expectedSongList, result);
        }
    }

    @Nested
    class FindByName {
        @Test
        void findByName_shouldReturnSong() {
            List<Song> result = songDao.findByName("Re-Hash");
            assertEquals(expectedSongList.get(0), result.get(0));
        }

        @Test
        void findByDifferentName_shouldReturnDifferentSong() {
            List<Song> result = songDao.findByName("5/4");
            assertEquals(expectedSongList.get(1), result.get(0));
        }

        @Test
        void findByNonExistentName_shouldReturnVoidList() {
            List<Song> result = songDao.findByName("Pepe");
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class FindByGenre {
        @Test
        void findByGenre_shouldReturnSong() {
            List<Song> result = songDao.findByGenre(1L);
            assertEquals(expectedSongList.get(0), result.get(0));
        }

        @Test
        void findByDifferentGenre_shouldReturnDifferentSong() {
            List<Song> result = songDao.findByGenre(2L);
            assertEquals(expectedSongList.get(2), result.get(0));
        }

        @Test
        void findByNonExistentGenre_shouldReturnVoidList() {
            List<Song> result = songDao.findByGenre(6L);
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class FindByPlaylist {
        @Test
        void findByPlaylist_shouldReturnSongs() {
            List<Song> result = songDao.getSongsByPlaylist(1L);
            assertEquals(expectedSongList.get(0), result.get(0));
        }

        @Test
        void findByDifferentPlaylist_shouldReturnDifferentSongs() {
            List<Song> result = songDao.getSongsByPlaylist(2L);
            assertEquals(expectedSongList.get(2), result.get(0));
        }

        @Test
        void findByNonExistentPlaylist_shouldReturnVoidList() {
            List<Song> result = songDao.getSongsByPlaylist(6L);
            assertTrue(result.isEmpty());
        }
    }
}
