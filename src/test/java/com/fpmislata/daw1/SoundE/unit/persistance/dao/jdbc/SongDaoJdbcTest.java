package com.fpmislata.daw1.SoundE.unit.persistance.dao.jdbc;

import com.fpmislata.daw1.SoundE.data.PlaylistData;
import com.fpmislata.daw1.SoundE.data.SongData;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.persistance.dao.SongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.SongDaoJdbc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class SongDaoJdbcTest {
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
            Song result = songDao.findById(9L);
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
            List<Song> expectedList = List.of(expectedSongList.get(0));

            assertEquals(expectedList, result);
        }

        @Test
        void findByDifferentName_shouldReturnDifferentSong() {
            List<Song> result = songDao.findByName("Change Ur Mind");
            List<Song> expectedList = List.of(expectedSongList.get(0));

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExisistentName_shouldReturnNull() {
            List<Song> result = songDao.findByName("pepe");
            assertTrue(result.isEmpty());
        }
    }
}
