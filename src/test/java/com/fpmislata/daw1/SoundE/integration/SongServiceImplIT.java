package com.fpmislata.daw1.SoundE.integration;

import com.fpmislata.daw1.SoundE.data.GenreData;
import com.fpmislata.daw1.SoundE.data.PlaylistData;
import com.fpmislata.daw1.SoundE.data.SongData;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.SongService;
import com.fpmislata.daw1.SoundE.domain.service.impl.SongServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.SongDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.SongRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.SongRepositoryImpl;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SongServiceImplIT extends JdbcTest {
    private final SongService songService = new SongServiceImpl(
            new SongRepositoryImpl (
                    new SongDaoJdbc()
            )
    );

    public final List<Song> SONG_LIST = SongData.SONG_LIST;
    public final List<Genre> GENRE_LIST = GenreData.GENRE_LIST;
    public final List<Playlist> PLAYLIST_LIST = PlaylistData.PLAYLIST_LIST;

    @Nested
    class FindById {
        @Test
        void findById_shouldReturnSong() {
            Song expected = SONG_LIST.get(0);

            Song result = songService.findById(1L);

            assertEquals(expected, result);
        }

        @Test
        void findByDifferentId_shouldReturnDifferentSong() {
            Song expected = SONG_LIST.get(1);

            Song result = songService.findById(2L);

            assertEquals(expected, result);
        }

        @Test
        void findByNonExistentId_shouldReturnNull() {
            Song result = songService.findById(20L);

            assertNull(result);
        }
    }

    @Nested
    class FindAll {
        @Test
        void findAll_shouldReturnAllSongs() {
            List<Song> result = songService.findAll();
            assertEquals(result, SONG_LIST);
        }
    }

    @Nested
    class FindByName {
        @Test
        void findByName_shouldReturnMatchingSong() {
            List<Song> result = songService.findByName("Re-Hash");
            List<Song> expectedList = List.of(SONG_LIST.get(0));

            assertEquals(expectedList, result);
        }

        @Test
        void findByName_shouldReturnMultipleMatchingSongs() {
            List<Song> result = songService.findByName("e");
            List<Song> expectedList = List.of(SONG_LIST.get(0), SONG_LIST.get(3), SONG_LIST.get(5), SONG_LIST.get(7));

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExistentName_shouldReturnEmptyList() {
            List<Song> result = songService.findByName("Pepe");
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class FindByGenre {

        //El primer test se ha borrado ya que no existe ningun género que solo equivalga a una canción

        @Test
        void findByGenre_shouldReturnMultipleMatchingSongs() {
            List<Song> result = songService.findByGenre(GENRE_LIST.get(1));
            List<Song> expectedList = List.of(SONG_LIST.get(2), SONG_LIST.get(3), SONG_LIST.get(4), SONG_LIST.get(5));

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExistentGenre_shouldReturnEmptyList() {
            List<Song> result = songService.findByGenre(new Genre(9L,"Inventado",null));
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class FindByPlaylist {

        //El primer test se ha borrado ya que no existe ningun género que solo equivalga a una canción

        @Test
        void findByPlaylist_shouldReturnMultipleMatchingSongs() {
            List<Song> result = songService.getSongsByPlaylist(PLAYLIST_LIST.get(1));
            List<Song> expectedList = List.of(SONG_LIST.get(2), SONG_LIST.get(3));

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExistentPlaylist_shouldReturnEmptyList() {
            List<Song> result = songService.getSongsByPlaylist(new Playlist(6L, "Inventada", null, "Inventado", null, null, null));
            assertTrue(result.isEmpty());
        }
    }
}
