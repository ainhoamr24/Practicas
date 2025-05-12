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
        void findByName_shouldReturnMatchingSong() {
            List<Song> result = songDao.findByName("Re-Hash");
            List<Song> expectedList = List.of(expectedSongList.get(0));

            assertEquals(expectedList, result);
        }

        @Test
        void findByName_shouldReturnMultipleMatchingSongs() {
            List<Song> result = songDao.findByName("e");
            List<Song> expectedList = List.of(expectedSongList.get(0), expectedSongList.get(3), expectedSongList.get(5), expectedSongList.get(7));

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExistentName_shouldReturnEmptyList() {
            List<Song> result = songDao.findByName("Pepe");
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class FindByGenre {

        //El primer test se ha borrado ya que no existe ningun género que solo equivalga a una canción

        @Test
        void findByGenre_shouldReturnMultipleMatchingSongs() {
            List<Song> result = songDao.findByGenre(2L);
            List<Song> expectedList = List.of(expectedSongList.get(2), expectedSongList.get(3), expectedSongList.get(4), expectedSongList.get(5));

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExistentGenre_shouldReturnEmptyList() {
            List<Song> result = songDao.findByGenre(6L);
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class FindByPlaylist {

        //El primer test se ha borrado ya que no existe ningun género que solo equivalga a una canción

        @Test
        void findByPlaylist_shouldReturnMultipleMatchingSongs() {
            List<Song> result = songDao.getSongsByPlaylist(2L);
            List<Song> expectedList = List.of(expectedSongList.get(2), expectedSongList.get(3));

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExistentPlaylist_shouldReturnEmptyList() {
            List<Song> result = songDao.getSongsByPlaylist(6L);
            assertTrue(result.isEmpty());
        }
    }
}
